package com.udemy.examples

val availableCars = arrayOf("Toyota", "Honda", "Nissan", "BMW")




class Dealer(var dealersMoney:Double = 500.0) {
    private val givenCars = arrayListOf<Car>()

    constructor(fon: Fon): this(fon.kazan())

    var boughtCars = arrayListOf<Car>() // Honda Jeep Toyota

    fun buy(car: Car, employee: String = "an employee") {
        println("Bought a ${car.brand} by $employee")
        boughtCars.add(car)
    }



    fun sell(brand: String, employee: String = "an employee") {
        val car = boughtCars.find {
            it.brand == brand
        } ?: throw Exception("There is no $brand")

        boughtCars.remove(car)
        println("Sold a $brand by $employee")
        println("Remaining cars: $boughtCars")

    }

    fun give(car: Car) : Car? {
        if(givenCars.size > 0)
            throw Exception("A Car is previously already given, wait for it to return")


        var result: Car? = null
        for (boughtCar in boughtCars) {
            if(boughtCar == car) {
                result = boughtCar
                givenCars.add(boughtCar)
                boughtCars.remove(car)
                println("Given car $car")
                break
            }
        }
        return result
    }

    fun takeBack(car: Car) : Boolean {
        if(givenCars.contains(car)) {
            boughtCars.add(car)
            givenCars.remove(car)
            print("Taken car $car")
            return true
        }

        throw Exception("No car is found")

    }
}

data class Car(var brand: String? = null) {
    init {
        brand = brand ?: availableCars[(Math.random() * 3).toInt()]
    }

    companion object {

    }
}



