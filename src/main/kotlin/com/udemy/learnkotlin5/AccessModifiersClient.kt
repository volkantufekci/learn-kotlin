package com.udemy.learnkotlin5

fun main() {
    println("${PublicClass()} called from a different file - AccessModifiersTest.kt")

    // We can not access private class from another file!!
    // This line will give compile error!
    // val privateClass = PrivateClass()

    println("${InternalClass()} is called from a different file - AccessModifiersTest.kt")

    println("$publicString is called from a different file - AccessModifiersTest.kt")

    // We can not access private variable from another file!!
    // This line will give compile error!
    // println("$privateString is called from a different file - AccessModifiersTest.kt")

    // We can call internal variable from anywhere in the same module that the variable is defined in.
    println("$internalString is called from a different file - AccessModifiersTest.kt")

    println("$bar") // We can access bar, since it is public
    //bar = 10 // Since setter is private we can not set bar here!
}