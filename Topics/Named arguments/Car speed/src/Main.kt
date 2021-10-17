fun main() {
    exceedsTheLimit(readLine()!!, readLine()!!)
}

fun exceedsTheLimit(speed: String, limit: String) {
    val actualLimit = if (limit == "no limit") "60" else limit

    println(if (speed.toInt() <= actualLimit.toInt()) "Within the limit" else "Exceeds the limit by ${speed.toInt() - actualLimit.toInt()} kilometers per hour")
}
