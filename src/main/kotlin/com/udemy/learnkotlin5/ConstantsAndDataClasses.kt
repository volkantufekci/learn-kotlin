package com.udemy.learnkotlin5

// We can declare top-level constants
val MY_CONSTANT = 100

// data class - stores state
fun main() {
    println(MY_CONSTANT)
    val car = Car("blue", "toyota", 2015)
    println(car)  // toString() function has already been implemented for the data class

    val car2 =  Car("blue", "toyota", 2015)
    println(car == car2) // we will get true, equals() function is already overridden.

    val car3 = car.copy() // We can copy properties from an existing car instance
    println("***** Car3 ****")
    println(car3)

    val car4 = car.copy(year=2018) // We can copy the properties other than year
    println("***** Car4 ****")
    println(car4)

    println("***** Regular Class - Employee ****")
    val emp1 = Employee("John")
    println(emp1) //  toString() function does not implemented for a regular class

    val emp2 = Employee("John")
    println(emp1 == emp2) // this is false since equals() is not overridden.
}


// data classes come with a custom implementation of the equals and hashcode functions and a copy function
// we can override if we need to write our own version
// primary constructor has ta have at least 1 parameter and this parameter has to be marked with val or var
// they store state information and not doing anything else
data class Car(val color: String, val model: String, val year: Int)



