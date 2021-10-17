package machine

interface Machine {

    fun buy()

    fun fill()

    fun take()

    fun remaining()

    fun takeOrder(): String

    fun isRunning(): Boolean

    fun stop()
}