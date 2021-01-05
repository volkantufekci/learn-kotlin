package com.udemy.learnkotlin3

fun main() {
    val something: Any = Student("hede", 1)
    if (something is Student) {  // Opposite is "!is"
//        val newStudent = something as Student // casting
//        println(newStudent.name)
        println(something.name) // Smart casting because of "if + is"
    }
}
