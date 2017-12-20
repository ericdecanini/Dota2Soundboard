package pandastudios.dotasound

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.support.annotation.LayoutRes
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.willowtreeapps.spruce.Spruce
import com.willowtreeapps.spruce.sort.DefaultSort
import kotlinx.android.synthetic.main.grid_item_hero.view.*

class HeroAdapter(internal var c: Context, @param:LayoutRes internal var resource: Int, internal var objects: List<Board>)
    : ArrayAdapter<Board>(c, resource, objects) {

    val LOG_TAG = HeroAdapter::class.java.simpleName
    private val handler = Handler()
    private val anim_duration_long = 1600L
    private val anim_duration_short = 150L

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var row = convertView
        var holder: ViewHolder? = null
        val hero = objects[position]

        if (row == null) {
            val inflater = (c as Activity).layoutInflater
            row = inflater.inflate(resource, parent, false)

            holder = ViewHolder(row)
            row.tag = holder
        } else {
            holder = row.tag as ViewHolder
        }

        holder.name!!.text = hero.name
        holder.image!!.setImageResource(hero.img)
        val portrait = holder.image!!.parent as View

        portrait.setOnTouchListener(View.OnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                Spruce.SpruceBuilder(view.parent as ViewGroup)
                        .sortWith(DefaultSort(50L))
                        .animateWith(Animations.growAnimator(view, anim_duration_short))
                        .start()
                holder!!.name!!.visibility = View.VISIBLE
                idleGrow(view)
            } else if (event.action == MotionEvent.ACTION_UP || event.action == MotionEvent.ACTION_CANCEL) {
                if (event.action == MotionEvent.ACTION_UP) {
                    // Handle OnClick event here
                    context.startActivity(Intent(context, SoundboardActivity::class.java))
                }
                Spruce.SpruceBuilder(view.parent as ViewGroup)
                        .sortWith(DefaultSort(50L))
                        .animateWith(Animations.shrinkAnimator(view, anim_duration_short))
                        .start()
                Spruce.SpruceBuilder(view as ViewGroup)
                        .sortWith(DefaultSort(50L))
                        .animateWith(Animations.shrinkAnimatorSmall(view, 10L))
                        .start()
                holder!!.name!!.visibility = View.GONE
                handler.removeCallbacksAndMessages(null)
            }
            true
        })

        return row!!
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

    class ViewHolder(view: View) {
        var image = view.image!!
        var name = view.name!!
    }
}