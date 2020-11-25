package pandastudios.dotasound

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_soundboard.*
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.muddzdev.styleabletoastlibrary.StyleableToast
import pandastudios.dotasound.data.DbHelper
import android.media.AudioManager
import android.net.Uri
import android.os.Environment
import android.os.FileObserver
import android.os.Handler
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.downloader_ui.*
import kotlinx.android.synthetic.main.splash_sounds_not_downloaded.*
import net.lingala.zip4j.core.ZipFile
import net.lingala.zip4j.exception.ZipException
import pandastudios.dotasound.R.id.morph_button
import pandastudios.dotasound.arrays.*
import java.io.File


@Suppress("PLUGIN_WARNING")
class SoundboardActivity : AppCompatActivity(), OnLoadAdsCompleted, OnAssignHeroesCompleted {

    private val LOG_TAG: String = SoundboardActivity::class.java.simpleName
    private lateinit var dbHelper: DbHelper

    private lateinit var miscArrays: MiscArrays
    var loadingTextArray: Array<String>? = null
    val handler = Handler()

    private var favourited = false
    private var favouriteInitialised = false

    private var isPhone = false
    private var isLandscape = false
    private var isTen = false

    private var id_attack: Int = -1
    private var id_ability: Int = -1
    private var id_items: Int = -1
    private var id_game: Int = -1
    private var id_encounters: Int = -1
    private var id_misc: Int = -1

    private val currentSoundsList = ArrayList<Sound>()
    private val currentSoundsListUnmorphed = ArrayList<Sound>()
    private val currentSoundsListMorphed = ArrayList<Sound>()
    private lateinit var soundsRecycler: SoundsRecycler

    private val soundsListAttack = ArrayList<Sound>()
    private val soundsListAttackMorphed = ArrayList<Sound>()
    private val soundsListAbilities = ArrayList<Sound>()
    private val soundsListAbilitiesMorphed = ArrayList<Sound>()
    private val soundsListItems = ArrayList<Sound>()
    private val soundsListItemsMorphed = ArrayList<Sound>()
    private val soundsListGame = ArrayList<Sound>()
    private val soundsListGameMorphed = ArrayList<Sound>()
    private val soundsListHeroRelated = ArrayList<Sound>()
    private val soundsListHeroRelatedMorphed = ArrayList<Sound>()
    private val soundsListMisc = ArrayList<Sound>()
    private val soundsListMiscMorphed = ArrayList<Sound>()

    private var heroKey = ""
    private var imageRes = R.drawable.board_header_ti7
    private var morphed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soundboard)
        volumeControlStream = AudioManager.STREAM_MUSIC
        loadingTextArray = resources.getStringArray(R.array.loading_texts)

        isPhone = resources.getBoolean(R.bool.is_phone)
        isLandscape = resources.getBoolean(R.bool.is_landscape)
        isTen = resources.getBoolean(R.bool.is_ten)

        this.miscArrays = MiscArrays(this)

        heroKey = intent.getStringExtra(getString(R.string.KEY_HERO))
        dbHelper = DbHelper(this)
        favourited = dbHelper.isFavourite(heroKey)

        // Setup the elements of the activity
        setupToolbar()
        setupSoundboard()
        setupAds()
    }

    private fun setupCategories() {
        sound_categories.visibility = View.VISIBLE

        // Get the ids of each button
        id_attack = category_attack.id
        id_ability = category_abilities.id
        id_items = category_items.id
        id_game = category_game.id
        id_encounters = category_encounters.id
        id_misc = category_misc.id

        // Set category icons
        category_attack.setImageResource(R.drawable.ic_sword)
        category_abilities.setImageResource(R.drawable.ic_add_white_24dp)
        category_items.setImageResource(R.drawable.ic_fitness_center_white_24dp)
        category_game.setImageResource(R.drawable.ic_games_white_24dp)
        category_encounters.setImageResource(R.drawable.ic_person_white_24dp)
        category_misc.setImageResource(R.drawable.ic_music_note_white_24dp)

        // Hide empty categories
        if (soundsListAttack.size == 0) {
            category_attack.visibility = View.GONE
        } else {
            category_attack.visibility = View.VISIBLE
        }
        category_abilities.visibility = if (soundsListAbilities.size == 0) View.GONE else View.VISIBLE
        category_items.visibility = if (soundsListItems.size == 0) View.GONE else View.VISIBLE
        category_game.visibility = if (soundsListGame.size == 0) View.GONE else View.VISIBLE
        category_encounters.visibility = if (soundsListHeroRelated.size == 0) View.GONE else View.VISIBLE
        category_misc.visibility = if (soundsListMisc.size == 0) View.GONE else View.VISIBLE

        if (soundsListAttack.isEmpty() && soundsListGame.isNotEmpty())
            category_game.performClick()

        sound_categories.setOnCheckedChangeListener { _, checkedId ->
            currentSoundsListUnmorphed.clear()
            currentSoundsListMorphed.clear()
            currentSoundsList.clear()

            when (checkedId) {
                id_attack -> {
                    currentSoundsListUnmorphed.addAll(soundsListAttack)
                    currentSoundsListMorphed.addAll(soundsListAttackMorphed)
                }
                id_ability -> {
                    currentSoundsListUnmorphed.addAll(soundsListAbilities)
                    currentSoundsListMorphed.addAll(soundsListAbilitiesMorphed)
                }
                id_items -> {
                    currentSoundsListUnmorphed.addAll(soundsListItems)
                    currentSoundsListMorphed.addAll(soundsListItemsMorphed)
                }
                id_game -> {
                    currentSoundsListUnmorphed.addAll(soundsListGame)
                    currentSoundsListMorphed.addAll(soundsListGameMorphed)
                }
                id_encounters -> {
                    currentSoundsListUnmorphed.addAll(soundsListHeroRelated)
                    currentSoundsListMorphed.addAll(soundsListHeroRelatedMorphed)
                }
                id_misc -> {
                    currentSoundsListUnmorphed.addAll(soundsListMisc)
                    currentSoundsListMorphed.addAll(soundsListMiscMorphed)
                }

                else -> {
                    currentSoundsListUnmorphed.addAll(soundsListMisc)
                    currentSoundsListMorphed.addAll(soundsListMiscMorphed)
                }
            }

            currentSoundsList.addAll(if (!morphed) currentSoundsListUnmorphed else currentSoundsListMorphed)
            currentSoundsList.add(Sound("", ""))
            currentSoundsList.add(Sound("", ""))
            soundsRecycler.notifyDataSetChanged()
        }
    }

    private fun setupAds() {
        LoadAdsTask(this).execute()
    }

    override fun onLoadAdsCompleted(adRequest: AdRequest) {
        adView.loadAd(adRequest)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar_title.text = heroKey
    }

    private fun setupSoundboard() {
        val numColumns = if (isTen) 3 else 2
        btn_sounds_not_downloaded.setOnClickListener { downloadSoundboard() }
        assignHeroToLists()

        soundsRecycler = SoundsRecycler(this, currentSoundsList)
        sounds_grid.adapter = soundsRecycler
        sounds_grid.layoutManager = GridLayoutManager(this, numColumns)
        sounds_grid.addItemDecoration(SpacesItemDecoration(resources.getDimension(R.dimen.grid_spacing).toInt(), numColumns))

        // Setup the morph button
        if (heroHasMorph()) {
            morph_button.visibility = View.VISIBLE
            morph_button.setOnClickListener { toggleMorph() }
        }

    }

    private fun downloadSoundboard() {
        // Setup Firebase Storage
        val storage = FirebaseStorage.getInstance()
        val heroRef = storage.reference.child("sounds").child("${heroKey.toLowerCase()}.zip")

        // Setup local file
        val heroFile = File(getExternalFilesDir(Environment.DIRECTORY_MUSIC), heroKey)

        // Prepare the UI
        splash_sounds_not_downloaded.visibility = View.GONE
        pb_soundboard.visibility = View.VISIBLE
        tv_progress.text = getString(R.string.downloading_hero, heroKey)

        // Download the file
        heroRef.getFile(heroFile).addOnCompleteListener {
            if (it.isCanceled) {
                // Handle error
                Log.e(LOG_TAG, "Error downloading sounds: ${it.exception?.message}")
                pb_soundboard.visibility = View.GONE
                splash_sounds_not_downloaded.visibility = View.VISIBLE
                tv_sounds_not_downloaded.text = getString(R.string.error_downloading_sounds)
                return@addOnCompleteListener
            }

            // DOWNLOAD COMPLETE
            tv_progress.text = getString(R.string.unzipping_hero, heroKey)
            unzipHero(heroFile.path)
        }
    }

    private fun unzipHero(path: String) {
        val destination = path.replace(Uri.parse(path).lastPathSegment, "")
        try {
            ZipFile(path).extractAll(destination)
            assignHeroToLists()
        } catch (e: ZipException) {
            e.printStackTrace()
        }
    }

    private fun toggleMorph() {
        morphed = !morphed
        morph_button.setImageResource(if (morphed) R.drawable.ic_morphed_silver else R.drawable.ic_unmorphed_silver)
        currentSoundsList.clear()

        currentSoundsList.addAll(if (morphed) currentSoundsListMorphed else currentSoundsListUnmorphed)
        currentSoundsList.add(Sound("", ""))
        currentSoundsList.add(Sound("", ""))

        soundsRecycler.notifyDataSetChanged()
    }

    private fun heroHasMorph(): Boolean = when (heroKey) {
        getString(R.string.Alchemist) -> false
        else -> false
    }

    fun isHeroKeyMusic(): Boolean {
        val heroKey = intent.getStringExtra(getString(R.string.KEY_HERO))
        return heroKey == getString(R.string.music)
    }

    private fun setStopVisibility(item: MenuItem) {
        if (isHeroKeyMusic()) item.isVisible = true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return if (menu != null) {
            menuInflater.inflate(R.menu.menu_soundboard, menu)
            toggleFavourite(menu.findItem(R.id.ic_favourite))
            setStopVisibility(menu.findItem(R.id.ic_stop))
            true
        } else false
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.ic_stop -> {
                soundsRecycler.stopMusic()
                true
            }
            R.id.ic_favourite -> {
                toggleFavourite(item)
                true
            }
            else -> false
        }
    }

    private fun toggleFavourite(item: MenuItem) {
        if (!favouriteInitialised) {
            favouriteInitialised = true
            if (favourited) item.setIcon(R.drawable.ic_star_white_24dp)
            else item.setIcon(R.drawable.ic_star_border_white_24dp)

        } else if (favourited) {
            favourited = false
            item.setIcon(R.drawable.ic_star_border_white_24dp)
            dbHelper.deleteFavourite(heroKey)
            StyleableToast.makeText(this, getString(R.string.removed_from_favourites),
                    Toast.LENGTH_SHORT, R.style.DotaToast).show()

        } else {
            favourited = true
            item.setIcon(R.drawable.ic_star_white_24dp)
            dbHelper.insertFavourite(heroKey, imageRes)
            StyleableToast.makeText(this, getString(R.string.added_to_favourites),
                    Toast.LENGTH_SHORT, R.style.DotaToast).show()
        }
    }

    private fun assignHeroToLists() {
        // Load arrays in the background
        handler.postDelayed(toggleLoadingText(), 5000)
        AssignHeroesTask(this, this).execute(heroKey)
    }

    override fun onAssignHeroesCompleted(available: Boolean, bundle: Bundle) {
        // Update the UI
        pb_soundboard.visibility = View.GONE
        handler.removeCallbacksAndMessages(null)

        if (!available) {
            splash_sounds_not_downloaded.visibility = View.VISIBLE
            return
        } else {
            splash_sounds_not_downloaded.visibility = View.GONE
        }

        // Add to the Arrays
        imageRes = bundle.getInt("imageRes")
        soundsListAttack.addAll(bundle.getSerializable("soundsListAttack") as ArrayList<Sound>)
        soundsListAttackMorphed.addAll(bundle.getSerializable("soundsListAttack") as ArrayList<Sound>)
        soundsListAbilities.addAll(bundle.getSerializable("soundsListAbilities") as ArrayList<Sound>)
        soundsListAbilitiesMorphed.addAll(bundle.getSerializable("soundsListAbilities") as ArrayList<Sound>)
        soundsListItems.addAll(bundle.getSerializable("soundsListItems") as ArrayList<Sound>)
        soundsListItemsMorphed.addAll(bundle.getSerializable("soundsListItems") as ArrayList<Sound>)
        soundsListGame.addAll(bundle.getSerializable("soundsListGame") as ArrayList<Sound>)
        soundsListGameMorphed.addAll(bundle.getSerializable("soundsListGame") as ArrayList<Sound>)
        soundsListHeroRelated.addAll(bundle.getSerializable("soundsListHeroRelated") as ArrayList<Sound>)
        soundsListHeroRelatedMorphed.addAll(bundle.getSerializable("soundsListHeroRelated") as ArrayList<Sound>)
        soundsListMisc.addAll(bundle.getSerializable("soundsListMisc") as ArrayList<Sound>)
        soundsListMiscMorphed.addAll(bundle.getSerializable("soundsListMisc") as ArrayList<Sound>) // Add all sounds to category arrays

        // Add current and blank sounds (UX against ad)
        currentSoundsList.addAll(if (soundsListAttack.size > 0) soundsListAttack else soundsListGame)
        currentSoundsList.add(Sound("", ""))
        currentSoundsList.add(Sound("", ""))



        (header_image as ImageView).setImageResource(imageRes)
        setupCategories()
        soundsRecycler.notifyDataSetChanged()

        // Add the board to the recents database table
        dbHelper.insertRecent(heroKey, imageRes)
    }

    private fun toggleLoadingText(): Runnable = Runnable {
        val choice = Math.floor(Math.random() * loadingTextArray!!.size).toInt()
        tv_progress.text = loadingTextArray!![choice]
        handler.postDelayed(toggleLoadingText(), 5000)
    }

}
