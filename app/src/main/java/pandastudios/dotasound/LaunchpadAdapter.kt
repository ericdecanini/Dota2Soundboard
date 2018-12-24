package pandastudios.dotasound

import android.app.Activity
import android.content.Context
import android.preference.PreferenceManager
import android.support.annotation.LayoutRes
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.zhouyou.view.seekbar.SignSeekBar
import pandastudios.dotasound.data.DbHelper
import java.util.*


class LaunchpadAdapter(internal var context: Context, @param:LayoutRes internal var resource: Int, internal var objects: Array<LaunchpadButton?>)
    : ArrayAdapter<LaunchpadButton?>(context, resource, objects) {

    val LOG_TAG = LaunchpadAdapter::class.java.simpleName
    var db: DbHelper = DbHelper(context)
    val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var button = convertView
        var holder: ViewHolder? = null
        val item = objects[position]

        if (button == null) {
            val inflater = (context as Activity).layoutInflater
            button = inflater.inflate(resource, parent, false)

            holder = ViewHolder(button)
            button.tag = holder
            holder.volumeButton.visibility = if ((context as LaunchpadActivity).showVolumeControl && objects[position] != null) View.VISIBLE else View.GONE
        } else {
            holder = button.tag as ViewHolder
        }

        // Set Volume Control
        // Set volumes on init of each button
        objects[position]?.let {
            holder.volumeButton!!.setProgress(objects[position]!!.volume * 10f)
        } ?: run {
            holder.volumeButton!!.setProgress(50f)
        }

        holder.volumeButton!!.setOnProgressChangedListener(object : SignSeekBar.OnProgressChangedListener {
            override fun onProgressChanged(signSeekBar: SignSeekBar, progress: Int, progressFloat: Float, fromUser: Boolean) {
                val volume = progressFloat / 100f
                val mp = (context as LaunchpadActivity).mediaPlayers[position]
                mp?.let { mp.setVolume(volume, volume) }
            }

            override fun getProgressOnActionUp(signSeekBar: SignSeekBar, progress: Int, progressFloat: Float) {
                // Save the volume in the db
                val volume = (progressFloat / 10).toInt()
                val launchpadNumber = preferences.getInt(context.getString(R.string.PREFERENCE_LAUNCHPAD_NUMBER), 0)
                db.updateLaunchpadButtonVolume(launchpadNumber, position, volume)

                // Set the volume of the current object
                (context as LaunchpadActivity).sounds[position]!!.volume = volume
            }

            override fun getProgressOnFinally(signSeekBar: SignSeekBar, progress: Int, progressFloat: Float, fromUser: Boolean) {
            }
        })

        // Return the view
        return button!!
    }

    class ViewHolder(view: View) {
        val volumeButton = view.findViewById<SignSeekBar>(R.id.seek_bar)
    }

}