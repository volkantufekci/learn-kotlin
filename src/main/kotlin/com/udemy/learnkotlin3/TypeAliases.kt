package com.udemy.learnkotlin3

typealias WorkerSet = Set<Worker>

fun main() {
    val workers: WorkerSet

    val names = arrayListOf("John", "Jane", "Mary")
    println(names[1]) // Jane
}

class Worker(var name: String, val id: Int) {

}


