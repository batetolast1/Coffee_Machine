package machine

const val WATER_PER_COFFEE = 200
const val MILK_PER_COFFEE = 50
const val COFFEE_BEANS_PER_COFFEE = 15

class CoffeeMachine : Machine {

    private val coffeeTypeTypes = listOf(CoffeeType.ESPRESSO, CoffeeType.LATTE, CoffeeType.CAPPUCCINO)
    private var water: Int
    private var milk: Int
    private var coffeeBeans: Int
    private var cups: Int
    private var totalMoney: Int
    private var running: Boolean

    init {
        totalMoney = 550
        water = 400
        milk = 540
        coffeeBeans = 120
        cups = 9
        running = true
    }

    override fun buy() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
        val userChoice = readLine()!!

        if (userChoice == "back") {
            return
        }

        val chosenCoffee = coffeeTypeTypes.find { it.id == userChoice.toInt() }!!

        if (canBuyCoffee(chosenCoffee)) {
            water -= chosenCoffee.water
            milk -= chosenCoffee.milk
            coffeeBeans -= chosenCoffee.coffeeBeans
            cups--
            totalMoney += chosenCoffee.price
        }
    }

    private fun canBuyCoffee(coffeeType: CoffeeType): Boolean {
        return if (water < coffeeType.water) {
            println("Sorry, not enough water!")
            false
        } else if (milk < coffeeType.milk) {
            println("Sorry, not enough milk!")
            false
        } else if (coffeeBeans < coffeeType.coffeeBeans) {
            println("Sorry, not enough coffee beans!")
            false
        } else if (cups == 0) {
            println("Sorry, not enough cups!")
            false
        } else {
            println("I have enough resources, making you a coffee!")
            true
        }
    }


//        val requiredCups = readLine()!!.toInt()
//        val availableCups = getAvailableCupsOfCoffee(water, milk, coffeeBeans)
//
//        when {
//            availableCups == requiredCups -> println("Yes, I can make that amount of coffee")
//            availableCups > requiredCups -> println("Yes, I can make that amount of coffee (and even ${availableCups - requiredCups} more than that)")
//            availableCups < requiredCups -> println("No, I can make only ${availableCups} cups of coffee")
//        }


    override fun fill() {
        println("Write how many ml of water do you want to add: ")
        val waterToAdd = readLine()!!.toInt()

        println("Write how many ml of milk  do you want to add: ")
        val milkToAdd = readLine()!!.toInt()

        println("Write how many grams of coffee beans  do you want to add")
        val coffeeBeansToAdd = readLine()!!.toInt()

        println("Write how many disposable cups of coffee do you want to add: ")
        val cupsToAdd = readLine()!!.toInt()

        require(waterToAdd >= 0)
        require(milkToAdd >= 0)
        require(coffeeBeansToAdd >= 0)
        require(cupsToAdd >= 0)

        water += waterToAdd
        milk += milkToAdd
        coffeeBeans += coffeeBeansToAdd
        cups += cupsToAdd
    }

    override fun take() {
        totalMoney = 0

        println("I gave you $$totalMoney")
    }

    override fun remaining() {
        println(
            """
            The coffee machine has:
            $water ml of water
            $milk ml of milk
            $coffeeBeans g of coffee beans
            $cups of disposable cups
            $totalMoney of money
            
            """.trimIndent()
        )
    }

    override fun takeOrder(): String {
        print("Write action (buy, fill, take): ")

        return readLine()!!
    }

    override fun isRunning() = running

    override fun stop() {
        running = false
    }

    private fun getAvailableCupsOfCoffee(water: Int, milk: Int, coffeeBeans: Int): Int {
        val portionsOfWater = water / WATER_PER_COFFEE
        val portionsOfMilk = milk / MILK_PER_COFFEE
        val portionsOfBeans = coffeeBeans / COFFEE_BEANS_PER_COFFEE

        return minOf(portionsOfWater, portionsOfMilk, portionsOfBeans)
    }
}