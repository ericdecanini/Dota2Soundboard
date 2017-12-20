package pandastudios.dotasound

import org.parceler.Parcel
import pandastudios.dotasound.R.id.name

@Parcel
class Sound {

    var soundRes: Int = 0
    var title: String = ""

    constructor() : super()

    constructor(soundRes: Int, title: String) : super() {
        this.soundRes = soundRes
        this.title = title
    }

}