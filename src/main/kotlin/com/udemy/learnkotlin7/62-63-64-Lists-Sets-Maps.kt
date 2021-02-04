package com.udemy.learnkotlin7

fun main(){
    // Collection interface is implemented by Set and List
    /*
        Collections are not mutable -> immutable
        Array is a collection



     */
    val strings = listOf("asd", "qwe")
    // no add-remove methods

    val strings2 = arrayListOf("q", "w", "e")
    println(strings2.javaClass)
    strings2.add("5")

    val strings3 = mutableListOf("q", "w", "e")
    println(strings3.javaClass)

    // from list to mutable list
    strings.toMutableList()

    // from mutable to immutable list
    strings2.toArray()

    // Spread operator -> Spreads array's values to varargs
    val array = arrayOf("1", "2", "3")
    val listFromArray = listOf(array) // list of 1 element, which is array
    println(listFromArray)
    val listFromArraySpread = listOf(*array) // list of 3 eleements, strings
    println(listFromArraySpread)
    println(listFromArraySpread[0])
    println(listFromArraySpread.get(0))

    // there are some conventional accessors
    listFromArraySpread.size
    listFromArraySpread.first()
    listFromArraySpread.last()
    listFromArraySpread.indexOf("3")
    listFromArraySpread.subList(fromIndex = 0, toIndex = 1)
    listFromArraySpread.asReversed()
    listFromArraySpread.forEach {
        // do something here
    }
    listFromArraySpread.map {
        "---$it---"
    }
    listFromArraySpread.filter {
        it.length > 1
    }
    listFromArraySpread.getOrNull(12) // There is no 12th index, so it returns null

    val listWithDuplicates = listOf(1,2,3) + listOf(3, 4, 5,6,7)
    println( listWithDuplicates ) // Merge two lists together

    val noDuplicateList = listOf(1,2,3).union(listOf(3, 4, 5,6,7))
    println(noDuplicateList)


    // MAPS - key value pairs
    println("****** MAPS **********")
    val pair: Pair<Int, String> = 3 to "Some other other String"
    val immutableMap = mapOf( 1 to "Some String", 2 to "Some other String", pair)
    // NO immutableMap.put method
    val mutableMap = hashMapOf( 1 to "Some String", 2 to "Some other String", pair)
    mutableMap.put(5, "Addition here")
    mutableMap.remove(2)

    // Pairs are used in maps, see above. We can also destructure pairs
    val pairToDeStructure = Pair(3, "asd") // 3 to asd also works
    val (key, value) = pairToDeStructure
    println("$key, $value")

    for(mapItem in mutableMap){
        // mapItem is of MutableMap.MapEntry value
        mapItem.key
        mapItem.value
    }

    // We destructured MutableMap.MapEntry class, but how about our own classes?
    // ERROR HERE BECAUSE "COMPONENT FUNCTIONS" NOT DEFINED: val (model1, make1, year1) = UnDeStructurableCarClass("BMW", "Z4", 2000)
    val (model2, make2, year2) = DeStructurableCarClass("BMW", "Z4", 2000)
    // DATA CLASSES ARE ALREADY DE-STRUCTURABLE
    val (model3, make3, year3) = CarDataClass("BMW", "Z4", 2000)


    // SETS -> SET -> KÜME
    println("****** SETS **********")
    val setInts = setOf(1,2,3,4)
    println(setInts)
    val newSet = setInts.plus(20)
    println(newSet)
    val newSet2 = setInts.plus(2)
    println(newSet2)
    val newSet3 = setInts.minus(20)
    println(newSet3)
    val newSet4 = setInts.minus(20) // NO RUNTIME ERRORS AS WELL
    println(newSet4)
    println(newSet4.drop(2)) // drop first 2 elements of the set
    println(newSet4)

    // Notice all operations return new set, now see MutableSet

    val mutableInSet = mutableSetOf(1,2,3)
    println(mutableInSet)
    mutableInSet.plus(10)
    mutableInSet.add(1000)
    println(mutableInSet)
    mutableInSet.remove(1)
    println(mutableInSet)
    // There are no add/remove on setOf(1,2,3)


    // For Collections, we have:
    println("****** COLLECTION METHODS **********")
    val arrayList = arrayListOf(1,2,3,4,5,6,7)
    println("All greater than 3? " + arrayList.all { it > 3 } )
    println("All greater than 0? " + arrayList.all { it > 0 } )
    println("Any greater than 3? " + arrayList.any { it > 3 } )
    println("Any greater than 1000? " + arrayList.any { it > 1000 } )
    println("Npne greater than 3? " + arrayList.none { it > 3 } )
    println("None greater than 1000? " + arrayList.none { it > 10000 } )
    println("Count of greater than 3? " + arrayList.count { it > 3 } )
    println("Find greater than 3? " + arrayList.find { it > 3 } )

    println("\nGroup by 3 ile bölümünden kalana gmre? " + arrayList.groupBy { it % 3 } )
    println("Group by greater than 3? " + arrayList.groupBy { it > 3 } )

    println("\nSorted by 3 ile bölümünden kalana gmre? " + arrayList.sortedBy { it % 3 } )


}

class UnDeStructurableCarClass(val model: String, val make: String, val year:Int)

class DeStructurableCarClass(val model: String, val make: String, val year:Int){
    operator fun component1() = model
    operator fun component2() = make
    operator fun component3() = year
}

data class CarDataClass(val model: String, val make: String, val year:Int){
    /* THESE LINES WILL THROW ERROR BECAUSE THEY ARE ALREADY IMPLEMENTED IN DATA CLASS
    operator fun component1() = model
    operator fun component2() = make
    operator fun component3() = year
     */
}
