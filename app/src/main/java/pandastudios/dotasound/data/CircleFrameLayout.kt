package pandastudios.dotasound.data

import android.content.Context
import android.widget.FrameLayout
import android.R.attr.path
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF




class CircleFrameLayout(internal val context: Context): FrameLayout(context) {

    override fun dispatchDraw(canvas: Canvas) {
        val path = Path()
        path.addRoundRect(RectF(0f, 0f, width.toFloat(), height.toFloat()), 10f, 10f, Path.Direction.CW)
        canvas.clipPath(path)
        super.dispatchDraw(canvas)
    }

}