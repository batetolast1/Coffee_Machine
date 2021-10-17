fun main() = readLine()!!.let {
    if (it.length % 2 == 0) {
        it.removeRange(it.length / 2 - 1, it.length / 2 + 1)
    } else {
        it.removeRange(it.length / 2, it.length / 2 + 1)
    }.let(::print)
}