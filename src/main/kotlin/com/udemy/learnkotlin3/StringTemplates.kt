package com.udemy.learnkotlin3

fun main() {
    val person = Person("volkan", 35)
    println(person) // Person(name=volkan, id=35)

    // open these
//    val change = 4.22
//    println("To show the value of change, we use $change") //To show the value of change, we use 4.22
//    println("Your change is $$change") //Your change is $4.22

    // open these
//    val numerator = 10.99
//    val denominator = 20.00
//    println("$numerator divided by $denominator is ${numerator/denominator}")
//    // 10.99 divided by 20.0 is 0.5495
}

class Person(var name: String, val id: Int) {
    override fun toString(): String {
        return "Person(name=$name, id=$id)"
    }
}

