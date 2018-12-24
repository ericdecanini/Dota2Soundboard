package pandastudios.dotasound

import android.os.Bundle
import com.google.android.gms.ads.AdRequest

interface OnAssignHeroesCompleted {
    fun onAssignHeroesCompleted(available: Boolean, bundle: Bundle)
}