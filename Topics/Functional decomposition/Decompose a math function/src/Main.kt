fun f(x: Double) = when {
    x <= 0 -> f1(x)
    x > 0 && x < 1 -> f2(x)
    else -> f3(x)
}

fun f1(x: Double) = x * x + 1

fun f2(x: Double) = 1 / (x * x)

fun f3(x: Double) = x * x - 1
