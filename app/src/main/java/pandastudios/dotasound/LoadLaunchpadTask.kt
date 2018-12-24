package pandastudios.dotasound

import android.content.Context
import android.os.AsyncTask
import com.google.android.gms.ads.AdRequest
import java.lang.Integer.getInteger

class LoadLaunchpadTask(var listener: OnLoadLaunchpadCompleted) : AsyncTask<Context, Void, ZipResourceFile>() {

    override fun doInBackground(vararg p0: Context?): ZipResourceFile {
        var expansionVersion = p0[0]!!.resources.getInteger(R.integer.expansion_version)
        var expansionFiles = APKExpansionSupport.getAPKExpansionZipFile(p0[0], expansionVersion, 0)
        return expansionFiles
    }

    override fun onPostExecute(result: ZipResourceFile?) {
        listener.onLoadLaunchpadCompleted(result!!)
    }

}
