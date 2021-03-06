package com.udemy.learnkotlin5

import com.udemy.examples.Dealer
import java.time.Year


// TODO: lessons learntı slıde lara koymak guzel olur

// object keyword usages:

// Singletons - only 1 instance of a class
//1. create an object named CompanyCommunications
//2. add a property named currentYear, Year.now().value
//3. add a function named getTagLine() returns String
//4. add getCopyrightLine() returning "Copyright \u00A9 $currentYear Our Company. All rights reserved."
//5. Call getTagLine() fun
//6. Call getCopyrightLine() fun
// Lessons learned - See how we can reach singleton class functions


object CompanyCommunications {
    private val currentYear = Year.now().value

    fun getTagLine() = "Our company is awesome"

    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Our Company. All rights reserved."

}

fun main() {
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyrightLine())

    println(CompanionObjectClass.accessPrivateVar())
    println(CompanionObjectClass.createdObjects)
    val obj1 = CompanionObjectClass.justAssign("")
    println("this time: "+CompanionObjectClass.createdObjects)

    var obj2 = CompanionObjectClass.justAssign("")
    println("this time: "+CompanionObjectClass.createdObjects)

    obj2 = CompanionObjectClass.justAssign("")
    println("this time: "+CompanionObjectClass.createdObjects)
    println(CompanionObjectClass.accessPrivateVar())


    val obj3: CompanionObjectClass = CompanionObjectClass.justAssign("Hello World")
    val obj4 = CompanionObjectClass.upperOrLowerCase("Hello World", false)

    val complexConstructor = MyClass(25.0)
    val complexConstructor2 = MyClass(obj3)

    val runnableObj = object: Walkable {
        override fun mustImplement(num: Int): String {
            return ""
        }

        override fun wantsSomeInterface(si: SomeInterface) {
        }
    }

    println("*******")
    println(runnableObj.wantsSomeInterface(object: SomeInterface { }))

}


// companion objects - static members of the class
// 1.create a class named CompanionObjectClass
// 2. add a private property named year with type Int
// 3. add a fun named accessPrivateVar() returns String and prints $year
// 4. Make this year property and accessPrivateVar() function as companion object
// 5. Reach this function without creating an instance of this class using Companion keyword
// 6. give name SpecialCompanion to the companion object, try to reach accessPrivateVar() fun using SpecialCompanion
// 7. Delete name and try to reach accessPrivateVar() fun without using Companion keyword
// Lessons learned - anything in the companion objects mean that we can reach them without creating an instance of a class

class CompanionObjectClass private constructor(var str: String){
    init {
        createdObjects++
    }

    companion object {
        internal var createdObjects = 0
        private val year: Int = -1
        fun accessPrivateVar() = "$year"
        fun justAssign(param: String) = CompanionObjectClass(param)
        fun upperOrLowerCase(param: String, lowerCase: Boolean): String = if(lowerCase) param.toLowerCase() else param.toUpperCase()

    }
}


class MyClass{

    constructor(x: Double)
    constructor(x: CompanionObjectClass)


}


// companion objects as factories
// 1.add a property to the CompanionObjectClass named str with type String
// 2.make CompanionObjectClass primary constructor private
// 3.add a justAssign(param: String): CompanionObjectClass fun to the companion object of
// the CompanionObjectClass and assign the property to the param
// 4. add a upperOrLowerCase(param: String, lowerCase: Boolean): String fun to the companion object
// you can use .toLowerCase() and toUpperCase() methods while implementing
// 5. create first instance of the CompanionObjectClass calling justAssign() fun with some value
// 6. create second instance of the CompanionObjectClass calling upperOrLowerCase() fun with some value and false option
// Lessons learned: We can use companion objects to create instances of classes as if it is a factory class




//Anonymous Objects
// 1. define an interface named MyInterface
// 2. add a fun mustImplement(num:Int) : String
// 3. create a fun wantsSomeInterface(si: SomeInterface) and print si.mustImplement() with an arg
// 4. call wantsSomeInterface() with anonymous obj by overriding mustImplement() func
// hint: (object: SomeInterface { override fun ... = ...})
// 5. create a var named thisIsMutable = 45
// 6. increment thisIsMutable in the anonymous obj fun
// 7. print thisIsMutable
// Lessons learned: If we want to call an object fun only once and destroy it after calling we can use anonymous obj

interface Walkable {

    fun mustImplement(num: Int) : String

    fun wantsSomeInterface(si : SomeInterface)
}
interface SomeInterface



//Enums
// 1. Create an enum class named Department
// 2. Add values HR,IT, ACCOUNTING and SALES
// 3. add 2 properties in the primary function with name fullName: String and numEmployees: Int
// 4. Fix errors by initializing each values of the enums
// 5. Add a fun getDepartmentInfo() = "The $fullName department has $numEmployees employee"
// 6. print Department.ACCOUNTING.getDeptInfo()
// Lessons learned: if you will add a fun in the enum class you need to put ; after the last enum value


//Imports in Kotlin
// 1. Create a new package named anotherpackage
// 2. Create a new kt file under this package named AnotherFile
// 2. Create a top level function in this file named printParam(str: String) = ...
// 3. Call printParam("${your name}") from the AnotherFile
// 4. Create a new module AnotherModule
// 5. Create a package under this module
// 6. Create a new file
// 7. Try to call printParam("${your name}") from this file
// 8. Rigth click to the new module and select Open Module Settings
// 9. Select AnotherModule and add Module Dependency and select kotlin
// While building it will also pull kotlin module
// 10. See you can call printParam("${your name}")
// 11. Try to call CompanyCommunication.getCopyrightLine object from that file
// 12. Try to call Department.IT from this file (only import this)
// 13. Import all of the enum (hint: using *)
// 14. import CompanyCommunication as Comm
// 15. Try to import and call String extension function under the Extensions file.





