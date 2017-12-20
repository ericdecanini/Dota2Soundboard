package pandastudios.dotasound

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SoundsRecycler(private val context: Context, private val mData: ArrayList<Sound>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal var LOG_TAG = SoundsRecycler::class.java.simpleName
    private var mPlayer: MediaPlayer? = null

    override fun getItemCount(): Int = mData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_button, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mData[position]
        val h = holder as ViewHolder

        h.button.text = item.title
        h.button.setOnClickListener {
            val soundRes = item.soundRes
            mPlayer = MediaPlayer.create(context, soundRes)
            mPlayer!!.setOnCompletionListener { mediaPlayer ->
                mediaPlayer.release()
            }
            mPlayer!!.start()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.button)
    }

}