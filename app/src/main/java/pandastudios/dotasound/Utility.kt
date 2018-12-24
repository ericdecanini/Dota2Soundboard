package pandastudios.dotasound

import android.content.Context

class Utility {

    fun generateNullSoundUris(context: Context): String {
        val buttonCount = context.resources.getInteger(R.integer.buttonCount)
        val builder = StringBuilder()
        for (i in 0 until buttonCount) {
            if (i != 0) builder.append(",")
            builder.append("null")
        }

        return builder.toString()
    }

    fun generateDefaultSoundVolumes(context: Context): String {
        val buttonCount = context.resources.getInteger(R.integer.buttonCount)
        val builder = StringBuilder()
        for (i in 0 until buttonCount) {
            if (i != 0) builder.append(",")
            builder.append("5")
        }

        return builder.toString()
    }


}