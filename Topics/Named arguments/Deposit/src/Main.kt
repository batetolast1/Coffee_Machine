import kotlin.math.pow

const val DEFAULT_AMOUNT = 1_000
const val DEFAULT_PERCENT = 5
const val DEFAULT_YEARS = 10

fun main() {
    val parameter = readLine()!!
    val value = readLine()!!.toInt()

    when (parameter) {
        "amount" -> print(calculateCompoundInterest(startingAmount = value))
        "percent" -> print(calculateCompoundInterest(yearlyPercent = value))
        "years" -> print(calculateCompoundInterest(years = value))
    }
}

fun calculateCompoundInterest(
    startingAmount: Int = DEFAULT_AMOUNT,
    yearlyPercent: Int = DEFAULT_PERCENT,
    years: Int = DEFAULT_YEARS,
) = (startingAmount * (1 + yearlyPercent / 100.0).pow(years)).toInt()