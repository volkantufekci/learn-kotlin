package com.udemy.learnkotlin5

// We can declare top-level constants
val MY_CONSTANT = 100

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

// data class - stores state
// data classes come with a custom implementation of the equals, toString, hashcode functions and a copy function
// we can override if we need to write our own version
// they store state information and not doing anything else
// we can exclude properties included by the automatically generated functions by declaring them inside the class body
data class Car(val color: String, val model: String, val year: Int)

// primary constructor has ta have at least 1 parameter and this parameter has to be marked with val or var
// Will give compile error
//data class DC()





