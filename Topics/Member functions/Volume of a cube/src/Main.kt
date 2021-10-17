data class Box(
    private var height: Double,
    private var width: Double,
    private var length: Double
) {

    fun getVolume() = height * width * length
}