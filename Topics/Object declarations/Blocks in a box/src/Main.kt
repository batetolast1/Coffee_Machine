class Block(val color: String) {
    object BlockProperties {
        var length = 4
        var width = 6

        fun blocksInBox(length: Int, width: Int) = (length / this.length) * (width / this.width)
    }
}
