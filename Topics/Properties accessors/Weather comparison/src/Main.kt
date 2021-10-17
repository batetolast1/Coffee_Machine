const val DUBAI = "Dubai"
const val MOSCOW = "Moscow"
const val HANOI = "Hanoi"

data class City(
    val name: String
) {
    var degrees: Int = when (name) {
        DUBAI -> 30
        MOSCOW -> 5
        HANOI -> 20
        else -> throw IllegalArgumentException("Exception")
    }
        set(value) {
            if (value in -92..57) {
                field = value
            } else {
                when (name) {
                    DUBAI -> field = 30
                    MOSCOW -> field = 5
                    HANOI -> field = 20
                }
            }
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City(DUBAI)
    firstCity.degrees = first
    val secondCity = City(MOSCOW)
    secondCity.degrees = second
    val thirdCity = City(HANOI)
    thirdCity.degrees = third

    // implement comparing here
    val cities = listOf(firstCity, secondCity, thirdCity)
    val lowest = cities.minOf { it.degrees }
    cities.filter { it.degrees == lowest }
        .let { if (it.size == 1) it[0].name else "neither" }
        .let { print(it) }
}
