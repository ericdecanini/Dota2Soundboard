package pandastudios.dotasound

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.willowtreeapps.spruce.Spruce
import com.willowtreeapps.spruce.sort.DefaultSort

class HeroesRecycler(private val context: Context, private val mData: List<SectionOrRow>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal var LOG_TAG = HeroesRecycler::class.java.simpleName

    private val handler = Handler()
    private val anim_duration_long = 1600L
    private val anim_duration_short = 150L

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        val item = mData[position]
        return if (!item.isRow) {
            0
        } else {
            1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.header_hero, parent, false)
            SectionViewHolder(v)
        } else {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_hero, parent, false)
            RowViewHolder(v)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mData[position]
        if (item.isRow) {
            val h = holder as RowViewHolder
            h.name.text = item.row.name
            h.image.setImageResource(item.row.img)

            val portrait = h.image.parent as View

            portrait.setOnTouchListener { view, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    Spruce.SpruceBuilder(view.parent as ViewGroup)
                            .sortWith(DefaultSort(50L))
                            .animateWith(Animations.growAnimator(view, anim_duration_short))
                            .start()
                    h.name.visibility = View.VISIBLE
                    idleGrow(view)
                } else if (event.action == MotionEvent.ACTION_UP || event.action == MotionEvent.ACTION_CANCEL) {
                    if (event.action == MotionEvent.ACTION_UP) {
                        // Handle OnClick event here
                        sendHeroIntent(item.row.name)
                    }
                    Spruce.SpruceBuilder(view.parent as ViewGroup)
                            .sortWith(DefaultSort(50L))
                            .animateWith(Animations.shrinkAnimator(view, anim_duration_short))
                            .start()
                    Spruce.SpruceBuilder(view as ViewGroup)
                            .sortWith(DefaultSort(50L))
                            .animateWith(Animations.shrinkAnimatorSmall(view, 10L))
                            .start()
                    h.name.visibility = View.GONE
                    handler.removeCallbacksAndMessages(null)
                }
                true
            }
        } else {
            val h = holder as SectionViewHolder
            h.headerText.text = item.section
            if (position == itemCount - 1)
                h.header.visibility = View.INVISIBLE
            else
                h.header.visibility = View.VISIBLE
        }
    }

    private fun sendHeroIntent(heroName: String) {
        val intent = Intent(context, SoundboardActivity::class.java)
        intent.putExtra(context.getString(R.string.KEY_HERO), heroName)
        context.startActivity(intent)
    }

    private fun idleGrow(view: View) {
        Spruce.SpruceBuilder(view as ViewGroup)
                .sortWith(DefaultSort(50L))
                .animateWith(Animations.growAnimatorSmall(view, anim_duration_long))
                .start()

        handler.postDelayed({ idleShrink(view) }, anim_duration_long)
    }

    private fun idleShrink(view: View) {
        Spruce.SpruceBuilder(view as ViewGroup)
                .sortWith(DefaultSort(50L))
                .animateWith(Animations.shrinkAnimatorSmall(view, anim_duration_long))
                .start()

        handler.postDelayed({ idleGrow(view) }, anim_duration_long)
    }

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val image: ImageView

        init {
            name = itemView.findViewById(R.id.name)
            image = itemView.findViewById(R.id.image)
        }
    }

    inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val header: View
        val headerText: TextView

        init {
            header = itemView.findViewById(R.id.header)
            headerText = itemView.findViewById<View>(R.id.header_text) as TextView
        }
    }

}