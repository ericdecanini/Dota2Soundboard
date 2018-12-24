package pandastudios.dotasound

import android.net.Uri
import org.parceler.Parcel

@Parcel
class LaunchpadButton {

    lateinit var soundUri: String
    var volume: Int = 5

    constructor() : super()

    constructor(soundUri: String, volume: Int) : super() {
        this.soundUri = soundUri
        this.volume = volume
    }

}