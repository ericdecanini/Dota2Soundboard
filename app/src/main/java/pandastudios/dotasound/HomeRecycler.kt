package pandastudios.dotasound

import android.content.Context
import android.content.Intent
import android.graphics.drawable.LayerDrawable
import android.media.MediaPlayer
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class HomeRecycler(private val context: Context, private val mData: ArrayList<Board>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal var LOG_TAG = HomeRecycler::class.java.simpleName

    override fun getItemCount(): Int = mData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_home, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val hero = mData[position]
        val h = holder as ViewHolder

        h.name.text = hero.name
        h.image.setImageResource(hero.img)

        h.parent.setOnClickListener {
            val intent = Intent(context, SoundboardActivity::class.java)
            intent.putExtra(context.getString(R.string.KEY_HERO), hero.name)
            context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.name)
        val parent: View = itemView.findViewById(R.id.root_layout)
    }

}