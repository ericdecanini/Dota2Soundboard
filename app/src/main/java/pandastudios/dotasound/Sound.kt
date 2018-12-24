package pandastudios.dotasound

import android.net.Uri
import org.parceler.Parcel

@Parcel
class Sound {

    lateinit var soundUri: String
    var title: String = ""

    constructor() : super()

    constructor(soundUri: String, title: String) : super() {
        this.soundUri = soundUri
        this.title = title
    }

}