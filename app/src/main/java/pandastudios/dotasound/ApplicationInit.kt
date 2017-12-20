package pandastudios.dotasound

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.squareup.leakcanary.LeakCanary
import pandastudios.dotasound.data.DbHelper

class ApplicationInit: Application() {

    override fun onCreate() {
        // Leak Canary setup
        setupLeakCanary()

        super.onCreate()

        // Admob setup
        setupAds()

        // Clean recents database table
        DbHelper(this).deleteOldRecents()
    }

    private fun setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
    }

    private fun setupAds() {
        // TODO: Switch to real account id before publishing
//        MobileAds.initialize(applicationContext, "ca-app-pub-8354184700142633~5407408070")
        MobileAds.initialize(applicationContext, applicationContext.getString(R.string.admob_id))

    }

}

