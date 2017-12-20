package pandastudios.dotasound

class Board {

    var img: Int = 0
    var name: String = ""

    constructor() : super()

    constructor(img: Int, name: String) : super() {
        this.img = img
        this.name = name
    }

}
