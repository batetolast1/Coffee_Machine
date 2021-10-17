class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        private var id: Int = 0
        var DEFAULT_HP = 100
        fun create(name: String): Player {
            return Player(id++, name, DEFAULT_HP)
        }
    }
}