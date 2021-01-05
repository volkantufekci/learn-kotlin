package com.udemy.learnkotlin3

fun main() {
    val filePath = """c:\hede\hodo"""

    // You don't need "line breaks" with triple quotes
    val nurseryRhyme1 = """Humpty Dumpty sat on the wall
Humpty Dumpty had a great fall
All the king's horses and all the king's men
Couldn't put Humpty together again."""
    println(nurseryRhyme1)

    println("-----------------------------")

    val eggName = "Humpty"
    val nurseryRhyme = """$eggName Dumpty sat on the wall
                        |$eggName Dumpty had a great fall
                        |All the king's horses and all the king's men
                        |Couldn't put $eggName together again.""".trimMargin()
        // "|" is the default for trimMargin
    println(nurseryRhyme)
}
