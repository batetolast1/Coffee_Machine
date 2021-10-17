package machine

enum class CoffeeType(
    val id: Int,
    val water: Int,
    val milk: Int,
    val coffeeBeans: Int,
    val price: Int
) {

    ESPRESSO(1, 250, 0, 16, 4),
    LATTE(2, 350, 75, 20, 7),
    CAPPUCCINO(3, 200, 100, 12, 6)
}