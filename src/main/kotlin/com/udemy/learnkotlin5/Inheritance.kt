package com.udemy.learnkotlin5

// Class Inheritance
// 1. Create a parent class named Printer

abstract class Printer(var modalName: String) {
    open fun printModal() {
        println(modalName)
    }

    abstract fun bestSellingPrice() : Double
}


// 2. Create a child class named LaserPrinter
open class LaserPrinter(modalName: String, var ppm: Int): Printer(modalName) {
    override fun printModal() {
        println("From Laser Printer $modalName")
    }

    override fun bestSellingPrice(): Double {
        TODO("Not yet implemented")
    }
}

class SpecialLaserPrinter(modalName: String, ppm: Int) : LaserPrinter(modalName, ppm) {
    override fun printModal() {
        println("From Special Laser Printer $modalName")
    }
}

// 3. add a property named modalName to the Printer
// 4. make Printer abstract
// 5. add printModal() function to the Printer and implement this

// 6. create an instance of Printer and call printModal()
fun main() {
    val printer: Printer = LaserPrinter("QWERTY", 5)
    printer.printModal()
}

// 7. override printModal() in the LaserPrinter

// 8. add abstract function named bestSellingPrice() (returns Double) to the Printer class
// 9. create a child class named SpecialLaserPrinter inherited from LaserPrinter
// 10. override printModal() in SpecialLaserPrinter
// 11. add final to printModal() in the LaserPrinter class
// 12. add a integer parameter to the class LaserPrinter constructor named ppm
// 13. create an open class named Something

open class Something(val x: Int) {
    private var someProperty: String = ""

    //constructor(someProperty: String) {
    //    this.someProperty = someProperty
    //}
}

class SomethingElse: Something {
    constructor(sth: Int): super(sth)
}

// 14. create a second constructor to this class with a one string property named someProperty (with secondary constructor)
// 15. create a class named SomethingElse and inherit it from Something
// 16. Add a property to the primary constructor to Something class named x : Int


// 17. Create a data class and try to add open to it
data class DC(val name: String): Something(5) {}


// Interfaces
// 1. Create an interface named MyInterface
interface MyInterface {
    val number:Int
    get() {return 5}
    fun myFunction(str: String): String {
        return  "adfsasdf"
    }
}

// 2. Create an interface named MySubInterface extends MyInterface
interface MySubInterface: MyInterface  {
    fun mySubFunction(num: Int) : String
}

class AClass: MySubInterface {
    override fun mySubFunction(num: Int): String {
        TODO("Not yet implemented")
    }
}

// 3. Add myFunction(str: String): String to the MyInterface
// 4. Add mySubFunction(num: Int) : String to the MySubInterface
// 5. create a class and extends from MySubInterface
// 6. Add a val property named number to the MyInterface
// 7. Add a custom getter to the property to the property name2 and make it concrete



