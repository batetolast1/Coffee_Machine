const val INITIAL_PRICE = 20_000

const val DEFAULT_YEARS = 5
const val YEAR_FACTOR = 2000

const val DEFAULT_SPEED = 120
const val SPEED_FACTOR = 100

const val DEFAULT_MILEAGE = 100_000
const val MILEAGE_STEP = 10_000
const val MILEAGE_FACTOR = 200

const val DEFAULT_TRANSMISSION = 0
const val TRANSMISSION_FACTOR = 1500

fun main() {
    val parameter = readLine()!!
    val value = readLine()!!.toInt()

    when (parameter) {
        "old" -> print(calculate(years = value))
        "passed" -> print(calculate(mileage = value))
        "speed" -> print(calculate(speed = value))
        "auto" -> print(calculate(auto = value))
    }
}

fun calculate(
    years: Int = DEFAULT_YEARS,
    mileage: Int = DEFAULT_MILEAGE,
    speed: Int = DEFAULT_SPEED,
    auto: Int = DEFAULT_TRANSMISSION,
) = listOf(
    INITIAL_PRICE,
    -years * YEAR_FACTOR,
    -(DEFAULT_SPEED - speed) * SPEED_FACTOR,
    -(mileage / MILEAGE_STEP) * MILEAGE_FACTOR,
    +if (auto == 1) TRANSMISSION_FACTOR else 0
).sum()