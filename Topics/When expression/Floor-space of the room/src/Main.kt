import kotlin.math.sqrt

fun main() {
    when (readLine()!!) {
        "triangle" -> getTriangle()
        "rectangle" -> getRectangle()
        "circle" -> getCircle()
    }
}

fun getCircle() {
    val r = readLine()!!.toDouble()
    println(r * r * 3.14)
}

fun getRectangle() {
    println(readLine()!!.toDouble() * readLine()!!.toDouble())
}

fun getTriangle() {
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble()
    val p = (a + b + c) / 2

    println(sqrt(p * (p - a) * (p - b) * (p - c)))
}
