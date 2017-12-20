package pandastudios.dotasound

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View

class Animations {

    companion object {
        val GROW_SCALE = 1.015f
        val SHRINK_SCALE = 1.1f
        val ORIGINAL_SCALE = 1.0f
        val ENLARGED_SCALE = 1.1f
        val FADE_AWAY_TO = 0.0f
        val FADE_IN_TO = 1.0f
        val START_ROTATION = 0f
        val END_ROTATION = 360f

        fun shrinkAnimator(view: View, duration: Long): Animator {
            return ObjectAnimator.ofPropertyValuesHolder(view,
                    PropertyValuesHolder.ofFloat(View.SCALE_X, ENLARGED_SCALE, ORIGINAL_SCALE),
                    PropertyValuesHolder.ofFloat(View.SCALE_Y, ENLARGED_SCALE, ORIGINAL_SCALE))
                    .setDuration(duration)
        }

        fun growAnimator(view: View, duration: Long): Animator {
            return ObjectAnimator.ofPropertyValuesHolder(view,
                    PropertyValuesHolder.ofFloat(View.SCALE_X, ORIGINAL_SCALE, ENLARGED_SCALE),
                    PropertyValuesHolder.ofFloat(View.SCALE_Y, ORIGINAL_SCALE, ENLARGED_SCALE))
                    .setDuration(duration)
        }

        fun shrinkAnimatorSmall(view: View, duration: Long): Animator {
            return ObjectAnimator.ofPropertyValuesHolder(view,
                    PropertyValuesHolder.ofFloat(View.SCALE_X, GROW_SCALE, ORIGINAL_SCALE),
                    PropertyValuesHolder.ofFloat(View.SCALE_Y, GROW_SCALE, ORIGINAL_SCALE))
                    .setDuration(duration)
        }

        fun growAnimatorSmall(view: View, duration: Long): Animator {
            return ObjectAnimator.ofPropertyValuesHolder(view,
                    PropertyValuesHolder.ofFloat(View.SCALE_X, ORIGINAL_SCALE, GROW_SCALE),
                    PropertyValuesHolder.ofFloat(View.SCALE_Y, ORIGINAL_SCALE, GROW_SCALE))
                    .setDuration(duration)
        }

    }


}