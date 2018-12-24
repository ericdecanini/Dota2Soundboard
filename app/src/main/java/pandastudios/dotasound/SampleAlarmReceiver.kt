package pandastudios.dotasound

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller

class SampleAlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        try {
            DownloaderClientMarshaller.startDownloadServiceIfRequired(
                    context,
                    intent,
                    SampleDownloaderService::class.java
            )
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }
}