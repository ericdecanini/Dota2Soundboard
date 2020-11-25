package pandastudios.dotasound

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.os.ParcelFileDescriptor.MODE_READ_ONLY
import android.os.ParcelFileDescriptor
import android.content.res.AssetFileDescriptor
import java.io.File
import android.content.res.AssetManager.ACCESS_BUFFER
import android.net.Uri
import android.os.Environment
import android.text.TextUtils.replace
import android.util.Log
import com.google.common.io.ByteStreams
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


class SoundsRecycler(private val context: Context, private val mData: ArrayList<Sound>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal var LOG_TAG = SoundsRecycler::class.java.simpleName
    private var mPlayer = MediaPlayer()

    val expansionVersion = context.resources.getInteger(R.integer.expansion_version)

    override fun getItemCount(): Int = mData.size

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder?) {
        super.onViewAttachedToWindow(holder)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_button, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mData[position]
        val h = holder as ViewHolder

        // Make button invisible if "Sound" is blank
        if (item.soundUri == "" && item.title == "") {
            h.button.visibility = View.INVISIBLE
        } else h.button.visibility = View.VISIBLE

        h.button.text = item.title
        h.button.setOnClickListener {
            // Sound button is pressed
            val soundPath =  Uri.parse(item.soundUri).lastPathSegment

            // Check if in Sound Selection mode (Launchpad)
            val selectingSound = (context as Activity).intent.getIntExtra(context.getString(R.string.INTENT_SELECTING_SOUND), -1)

            // Return to Launchpad if so-
            if (selectingSound > -1) {
                val intent = Intent(context, LaunchpadActivity::class.java)
                intent.putExtra(context.getString(R.string.INTENT_EXTRA_URI), Uri.parse(item.soundUri).lastPathSegment)
                intent.putExtra(context.getString(R.string.INTENT_SELECTING_SOUND), selectingSound)
                context.startActivity(intent)
                context.finish()
                return@setOnClickListener
            }

            // Parse sound asset Uri into AFD and pass into MediaPlayer
            val soundFile = File(context.getExternalFilesDir(Environment.DIRECTORY_MUSIC), soundPath)
            var soundAfd: AssetFileDescriptor? = null

            try {
                soundAfd = AssetFileDescriptor(ParcelFileDescriptor.open(soundFile, MODE_READ_ONLY), 0, -1)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                val heroFile = File(context.getExternalFilesDir(Environment.DIRECTORY_MUSIC), (context as SampleTabActivity).heroKey.replace(" ", ""))
                context.unzipHero(heroFile.path)
            }


            if ((context as SampleTabActivity).isHeroKeyMusic()) {
                mPlayer.reset()
            } else {
                mPlayer = MediaPlayer()
            }

            // Error check: Sounds may not have unzipped properly
            if (soundAfd == null) {
                context.reunzipHero()
                return@setOnClickListener
            }

            mPlayer.setDataSource(soundAfd.fileDescriptor, soundAfd.startOffset, soundAfd.length)
            mPlayer.prepare()


            mPlayer.setOnCompletionListener { mediaPlayer ->
                mediaPlayer.reset()
            }

            mPlayer.start()
        }
    }

    fun stopMusic() {
        mPlayer.stop()
    }

    @Throws(IOException::class)
    private fun copyToCacheFile(assetPath: String, cacheFile: File) {
        val inputStream = context.assets.open(assetPath, ACCESS_BUFFER)
        inputStream.use { inputStream ->
            val fileOutputStream = FileOutputStream(cacheFile, false)
            fileOutputStream.use { fileOutputStream ->
                //using Guava IO lib to copy the streams, but could also do it manually
                ByteStreams.copy(inputStream, fileOutputStream)
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.button)
    }

}