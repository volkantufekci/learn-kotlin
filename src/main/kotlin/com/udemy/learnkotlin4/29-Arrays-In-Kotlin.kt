package com.udemy.learnkotlin4

import java.math.BigDecimal

fun main(){
    val arrayOfStrings = arrayOf("asd", "qwe")

    // arrayOf is generic method
    val inferredArray = arrayOf(1L, 2L, 3L) // inferredArray is array of Longs

    // Auto convert will take place if you write type explicitly
    val explicitLongArray: Array<Long> = arrayOf(1,2,3)

    println(explicitLongArray[0]) // Array access

    // We cam also Use Array Constructors
    val evenNumbers = Array(20) { i -> i*2 } //Contains Lambda
    println(evenNumbers.joinToString("-"))

    val intArray = arrayOf(1,2,3)
    println("first item: ${intArray[0]}")
    // imtArray = arrayIf(3,4) is invalid because of val but..
    intArray[0] = 1000
    println("first item: ${intArray[0]}")  // array itself is the same, but the content is changed, val/var applies to = assignments

    // Arrays must have type
    // intArray[0] = "asddasd"  invalid because type inference said intArray is Array<Int>

    val mixedArray = arrayOf("hello", 12, BigDecimal(1.2), 'c')
    //println(mixedArray is Array<Any>)

    // now we can change the first element
    mixedArray[0] = 99
    println(mixedArray.joinToString("-"))

    // Below two lines work in course, but gives weird error here
    // WONT WORK SomeJavaClass().printPrimitiveJavaInts(arrayOf(1,2,3))
    //SomeJavaClass.printPrimitiveJavaInts(intArrayOf(1,2,3))

    // This worked because intArrayOf() returns primitive int array
    // Kotlin converts Int to int, but IntArray of Kotlin doesnt convert to int[] of Java automatically. use .toIntArray()

    // intArrayOf() - charArrayOf() -> they also have performance boost
    // Course doesn't say by how much

    val someArray = IntArray(5) // -> array has default values
    // var thisWontWork = Array<Int>(50) //needs initializer lambda
    println(someArray.joinToString("-"))

}