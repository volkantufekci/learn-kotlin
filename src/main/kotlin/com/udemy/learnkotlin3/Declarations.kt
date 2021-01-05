package com.udemy.learnkotlin3

fun main() {
    val number = 25 // default data type for numbers is Int
    val number2: Int // no need to assign an initial number

    val numberShort: Short = 25 // To get Short type you need to mention it

    number2 = 10
//    number2 = 20 // Not allowed as it is defined as "val"

    var number3 = 1 // Mutable variables are underlined
//    number3 = "hede" // Not allowed

    val employee1 = Employee("Lynn Jones", 500)
    employee1.name = "Lynn Smith"

    // This assignment is allowed
    // val is similar to final in java
    val employee2: Employee
    if (number < number2) {
        employee2 = Employee("Jane Smith", 400)
    } else {
        employee2 = Employee("Mike Watson", 150)
    }

}

class Employee(var name: String, val id: Int) {
    //id is defined as "val" as it never changes
}