package com.udemy.learnkotlin7

fun main(){
    val someList = arrayListOf(1,2,3)
    // Notice the arrayListOf<String> go to definition

    // That was Generic function
    // Write a generic method that runs over any list (extension), and it prints the list items ||    fun <T> List<T>.printCollection(){
    // We can write fun <T:Number> convertToInt(collection: List<T>){ print collection[i].toInt()

    // SKIPPING inline fun <reified T> filterTsInAListOfAny(list:List<Any>)
    // -> reification is only needed when we are going to write if(item is T)


    val myArrayList = getMyArrayList(1,3,4,5,)
    val myArrayList2 = getMyArrayList("asd", "qwe")
    val myArrayList3 = getMyArrayList(Car2(), Car2())

    val importantList = listOf(1,2,3)
    importantList.myImportantPrint()
    val x = Int

}

class Car2

fun <Whatever> getMyArrayList(vararg whatevers : Whatever) : ArrayList<Whatever> {
    val arrayListToReturn: ArrayList<Whatever> = arrayListOf()
    for (item in whatevers){
        arrayListToReturn.add(item)
    }
    return arrayListToReturn
}


fun <Whatevs> List<Whatevs>.myImportantPrint() {
    for (item in this)
        println("****** $item")
}


