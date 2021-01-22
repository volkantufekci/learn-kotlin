package com.udemy.learnkotlin3


fun main(args: Array<String>)  {
    val studentOne = Student("Mary", 1)
    val studentTwo = Student("John", 2)
    val studentThree = Student("John", 2)

    //Structural Equality (same as .equals())
    println("studentOne == studentTwo ${studentOne == studentTwo}")       //false !!!
    println("studentTwo == studentThree ${studentTwo == studentThree}")   //true

    // Referential Equality
    println("studentOne === studentTwo ${studentOne === studentTwo}")     //false
    println("studentTwo === studentThree ${studentTwo === studentThree}") //false

    val studentFour = studentTwo
    println("studentFour === studentTwo ${studentFour === studentTwo}")   //true

    println("studentFour != studentTwo ${studentFour != studentTwo}")     //false
    println("studentFour !== studentTwo ${studentFour !== studentTwo}")   //false
    println("studentTwo != studentThree ${studentTwo != studentThree}")   //false
    println("studentTwo !== studentThree ${studentTwo !== studentThree}") //true

    val something: Any = studentFour
    if (something is Student) {  // Opposite is "!is"
//        val newStudent = something as Student // casting
//        println(newStudent.name)
        println(something.name) // Smart casting because of "if + is"
    }
}

class Student(var name: String, val id : Int) {

    override fun equals(obj: Any?): Boolean {
        // Checks structural equality
        if (obj is Student) {
            return name == obj.name && id == obj.id
        }

        return false
    }

}


