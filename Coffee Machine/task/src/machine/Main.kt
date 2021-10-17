package machine

fun main() {
    val coffeeMachine = CoffeeMachine()

    while (coffeeMachine.isRunning()) {
        when (coffeeMachine.takeOrder()) {
            "buy" -> coffeeMachine.buy()
            "fill" -> coffeeMachine.fill()
            "take" -> coffeeMachine.take()
            "remaining" -> coffeeMachine.remaining()
            "exit" -> coffeeMachine.stop()
        }
    }
}
