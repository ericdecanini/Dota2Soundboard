package pandastudios.dotasound

import android.content.Context
import com.nex3z.togglebuttongroup.button.CompoundToggleButton
import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.willowtreeapps.spruce.Spruce
import com.willowtreeapps.spruce.sort.DefaultSort


class CategoryButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : CompoundToggleButton(context, attrs) {

    private var mPlaying: Boolean = false
    private var animations: Animations
    private lateinit var parentView: View

    init {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        parentView = inflater.inflate(R.layout.button_category, this, true)
        animations = Animations()
    }

    override fun performClick(): Boolean = !mPlaying && super.performClick()

    override fun setChecked(checked: Boolean) {
        super.setChecked(checked)
        playAnimation(checked)
    }

    fun setImageResource(res: Int) {
        parentView.findViewById<ImageView>(R.id.icon).setImageResource(res)
    }

    private fun playAnimation(checked: Boolean) {
        val icon = parentView.findViewById<ImageView>(R.id.icon)
        val animDuration = 800L

        if (!checked) {
            Spruce.SpruceBuilder(parentView as ViewGroup)
                    .sortWith(DefaultSort(50L))
                    .animateWith(Animations.shrinkAnimator(parentView, animDuration))
                    .start()
            icon.setColorFilter(resources.getColor(R.color.white))
        } else {
            Spruce.SpruceBuilder(parentView as ViewGroup)
                    .sortWith(DefaultSort(50L))
                    .animateWith(Animations.growAnimator(parentView, animDuration))
                    .start()
            icon.setColorFilter(resources.getColor(R.color.colorHighlight))
        }
    }

    private inner class CheckedAnimationListener : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator) {
            mPlaying = true
        }

        override fun onAnimationEnd(animation: Animator) {
            mPlaying = false
        }

        override fun onAnimationCancel(animation: Animator) {
            mPlaying = false
        }

        override fun onAnimationRepeat(animation: Animator) {
            mPlaying = true
        }
    }

    companion object {
        private val LOG_TAG = CategoryButton::class.java.simpleName
    }
}