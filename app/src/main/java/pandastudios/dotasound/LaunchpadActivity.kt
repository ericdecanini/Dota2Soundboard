package pandastudios.dotasound

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.AudioManager
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.ParcelFileDescriptor
import android.preference.PreferenceManager
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.common.io.ByteStreams
import com.muddzdev.styleabletoastlibrary.StyleableToast
import kotlinx.android.synthetic.main.activity_launchpad.*
import pandastudios.dotasound.data.DbHelper
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import android.widget.AdapterView
import android.widget.EditText
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.downloader_ui.*


class LaunchpadActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val LOG_TAG = LaunchpadActivity::class.java.simpleName

    var buttonCount = 16
    lateinit var sounds: Array<LaunchpadButton?>
    lateinit var soundAfds: Array<AssetFileDescriptor?>
    lateinit var mediaPlayers: Array<MediaPlayer?>

    var loadingTextArray: Array<String>? = null
    val handler = Handler()

    val db = DbHelper(this)
    var launchpadNum = 0
    var launchpadTitles = arrayOfNulls<String?>(8)

    var showVolumeControl = false

    lateinit var launchpadAdapter: LaunchpadAdapter
    lateinit var launchpadMenuAdapter: ArrayAdapter<String?>
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launchpad)
        volumeControlStream = AudioManager.STREAM_MUSIC
        preferences = PreferenceManager.getDefaultSharedPreferences(this)
        loadingTextArray = resources.getStringArray(R.array.loading_texts)

        // Init toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        title = ""

        // Lock Orientation
        requestedOrientation = resources.configuration.orientation

        initLaunchpad()
        initSpinner()
        initEdit()
        setupAds()
        checkIncomingSound()
    }

    private fun toggleLoadingText(): Runnable = Runnable {
        val choice = Math.floor(Math.random() * loadingTextArray!!.size).toInt()
        tv_progress.text = loadingTextArray!![choice]
        handler.postDelayed(toggleLoadingText(), 5000)
    }

    private fun initEdit() {
        iv_launchpad_edit.setOnClickListener {
            // Init the Builder
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.dialog_set_launchpad_title))

            // Add the EditText
            val input = EditText(this)
            builder.setView(input)

            // Set up the buttons
            builder.setPositiveButton(getString(R.string.OK)) { _, _ ->
                launchpadTitles[launchpadNum] = input.text.toString()
                db.updateLaunchpadTitle(launchpadNum, launchpadTitles[launchpadNum]!!)
                launchpadMenuAdapter.notifyDataSetChanged()
            }.setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }

            // Show the dialog
            builder.show()
        }
    }

    private fun loadLaunchpad() {
        // Load sounds and reset adapter
        sounds = db.getLaunchpadById(this, launchpadNum)
        launchpadAdapter = LaunchpadAdapter(this, R.layout.grid_item_launchpad, sounds)
        gv_launchpad.adapter = launchpadAdapter

        // Set launchpad title
        launchpadTitles[launchpadNum] = db.getLaunchpadTitle(launchpadNum)
        spinner_launchpad.prompt = launchpadTitles[launchpadNum]
    }

    private fun checkIncomingSound() {
        // Check if intent has incoming sound data
        if (!intent.hasExtra(getString(R.string.INTENT_EXTRA_URI)))
            return

        val selectedSoundUri = intent.getStringExtra(getString(R.string.INTENT_EXTRA_URI))
        val selectedSoundNumber = intent.getIntExtra(getString(R.string.INTENT_SELECTING_SOUND), -1)

        // Assign the sound to the array and save to db
        sounds = db.getLaunchpadById(this, launchpadNum)
        sounds[selectedSoundNumber]?.let {
            sounds[selectedSoundNumber]?.soundUri = selectedSoundUri
        } ?: run {
            sounds[selectedSoundNumber] = LaunchpadButton(selectedSoundUri, 5)
        }

        // Save the array to db
        db.updateLaunchpad(launchpadNum, launchpadTitles[launchpadNum]!!, concatenateSoundUris(), concatenateVolumes())
    }

    private fun initSpinner() {
        // Get launchpad titles
        launchpadTitles = db.getLaunchpadTitles()
        launchpadMenuAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, launchpadTitles)
        spinner_launchpad.adapter = launchpadMenuAdapter

        // Set selection and set name
        spinner_launchpad.setSelection(launchpadNum)
        spinner_launchpad.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>, v: View?, position: Int, id: Long) {
        launchpadNum = position
        loadLaunchpad()

        // Save the position so it returns there on next launch
        preferences.edit().putInt(getString(R.string.PREFERENCE_LAUNCHPAD_NUMBER), position).apply()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

    private fun initLaunchpad() {
        buttonCount = resources.getInteger(R.integer.buttonCount)
        sounds = arrayOfNulls(buttonCount)
        soundAfds = arrayOfNulls(buttonCount)
        mediaPlayers = arrayOfNulls(buttonCount)

        // Load Volume Control Settings
        showVolumeControl = preferences.getBoolean(getString(R.string.PREFERENCE_SHOW_VOLUME_CONTROL), false)

        // Load launchpad
        launchpadNum = preferences.getInt(getString(R.string.PREFERENCE_LAUNCHPAD_NUMBER), 0)
        sounds = db.getLaunchpadById(this, launchpadNum)

        // Setup adapter
        launchpadAdapter = LaunchpadAdapter(this, R.layout.grid_item_launchpad, sounds)
        gv_launchpad.adapter = launchpadAdapter

        // Launchpad OnItemClickListener
        gv_launchpad.setOnItemClickListener { _, _, i, _ ->
            if (sounds[i] == null) {
                // Sound null: show toast
                StyleableToast.makeText(this, getString(R.string.toast_launchpad_prompt_longpress), Toast.LENGTH_SHORT, R.style.DotaToast).show()
            } else {
                // Sound available: play sound
                playSound(sounds[i], i)
            }
        }

        // Launchpad OnItemLongClickListener
        gv_launchpad.setOnItemLongClickListener { _, _, i, _ ->
            // Change URL of song
            launchAssignSound(i)
        }

    }

    fun playSound(sound: LaunchpadButton?, i: Int) {
        val soundUri = sound?.soundUri
        val volume: Float = sound!!.volume.toFloat() / 10

        val soundFile = File(getExternalFilesDir(Environment.DIRECTORY_MUSIC), soundUri)
        val soundAfd = AssetFileDescriptor(ParcelFileDescriptor.open(soundFile, ParcelFileDescriptor.MODE_READ_ONLY), 0, -1)

        mediaPlayers[i] = MediaPlayer()
        mediaPlayers[i]!!.setDataSource(soundAfd.fileDescriptor, soundAfd.startOffset, soundAfd.length)
        mediaPlayers[i]!!.setVolume(volume, volume)
        mediaPlayers[i]!!.prepare()

        mediaPlayers[i]!!.setOnCompletionListener { mediaPlayer ->
            mediaPlayer.reset()
        }

        mediaPlayers[i]!!.start()

    }

    private fun launchAssignSound(i: Int): Boolean {
        val intent = Intent(this, HeroesActivity::class.java)
        intent.putExtra(getString(R.string.INTENT_SELECTING_SOUND), i)
        startActivity(intent)
        return true
    }

    fun concatenateSoundUris(): String {
        val builder = StringBuilder()
        for (i in 0 until sounds.size) {
            if (i != 0) builder.append(",")
            builder.append(sounds[i]?.soundUri ?: run { "null" })
        }

        return builder.toString()
    }

    fun concatenateVolumes(): String {
        val builder = StringBuilder()
        for (i in 0 until sounds.size) {
            if (i != 0) builder.append(",")

            if (sounds[i] == null) {
                builder.append("5")
            } else {
                builder.append(Integer.toString(sounds[i]!!.volume))
            }

        }

        return builder.toString()
    }

    private fun setupAds() {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return menu?.let {
            menuInflater.inflate(R.menu.menu_launchpad, menu)
            if (showVolumeControl) menu.findItem(R.id.ic_volume).isChecked = true
            true
        } ?: run { false }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId) {
            R.id.ic_stop -> {
                for (player in mediaPlayers) player?.reset()
                true
            }

            R.id.ic_volume -> {
                item.isChecked = !item.isChecked
                showVolumeControl = item.isChecked
                preferences.edit().putBoolean(getString(R.string.PREFERENCE_SHOW_VOLUME_CONTROL), showVolumeControl).apply()

                // Reset the adapter
                launchpadAdapter = LaunchpadAdapter(this, R.layout.grid_item_launchpad, sounds)
                gv_launchpad.adapter = launchpadAdapter
                true
            }

            android.R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }

            else -> false
        }
    }


    @Throws(IOException::class)
    private fun copyToCacheFile(assetPath: String, cacheFile: File) {
        val inputStream = assets.open(assetPath, AssetManager.ACCESS_BUFFER)
        inputStream.use { inputStream ->
            val fileOutputStream = FileOutputStream(cacheFile, false)
            fileOutputStream.use { fileOutputStream ->
                //using Guava IO lib to copy the streams, but could also do it manually
                ByteStreams.copy(inputStream, fileOutputStream)
            }
        }
    }

}