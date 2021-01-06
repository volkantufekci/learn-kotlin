package com.udemy.learnkotlin4

fun main(){
    val nulledArray = arrayOfNulls<Int>(5)
    for(i in nulledArray)
        println(i) // i is Int?, for details Hold Command and hover over arrayOfNulls method
}