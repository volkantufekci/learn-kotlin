package com.udemy.learnkotlin4

fun main(){
    // In java you can write String x; -> x is null now, x="asd" -> now contains String
    // val str: String = null -> WONT WORK
    val str: String? = null

    val notNull: String? = "Not Null"
    // println(notNull.toUpperCase()) // WONT WORK
    println(notNull?.toUpperCase()) // NEEDS SAFECALL

    if(notNull != null)
        println(notNull?.toUpperCase()) // No need for ? now - SMARTCAST

    var isNull: String? = null
    println(isNull?.toUpperCase())

    /* UNCOMMENT THIS FOR EXAMPLE
    if(isNull==null){
        val string1: String = isNull?.toUpperCase()
    }
     */

    var nullableString: String? = "asd"
    // SEE THE DEFINITION OF MYSAFEUPPER
    println(mySafeUpperCase(nullableString))

    // SAFE ARGs can be chained
    /*
        JAVA's
        Address address;
        Building building;
        Home home;

        address = database.getAddress()
        if(address != null){
            building = address.getBuilding()
            if(building != null){
                home = building.getHome()
                if(home!=null)
                    System.out.println(home)
            }
        }


        can be written in kotlin as

        println(database.getAddress()?.getBuilding()?.getHome())

        or with property access

        database.address?.building?.home

     */

    // Elvis operator ?: -> Looks like Elvis Presley
    // Use if not null, or, use the right side of elvis
    val nulled: String? = null
    val notNulled: String? = "some string here"

    val definitelyNotNullString = nulled ?: "use this"
    val definitelyNotNullString2 = notNulled ?: "use that"

    println(definitelyNotNullString)
    println(definitelyNotNullString2)

    // NULL-SAFE OPERATOR + ELVIS = ALWAYS NOT NULL
    // database.address?.building?.home ?: myHome -> Always a home

    // as? -> Safe convert -> Like safe call, but for conversions
    val someUnconvertable: Array<Int> = arrayOf(1,2,33)
    val resultOfImpossibleConversion = someUnconvertable as? Double
    println("$resultOfImpossibleConversion")

    // Notice this cast can never succeed on as?, remove ? and run it as "as" and see error we dodged
    val explicitStringOfImpossible /* : String */ = someUnconvertable as? String

    // " as? T "  ->   will return T?
    // Uncomment /* : String */ on line 76 for demo


}

fun mySafeUpperCase(str: String?): String? {
    // BELOW IS THE TRANSLATION OF nullableString?.toUpperCase()
    if(str == null){
        return null
    }
    else {
        return str.toUpperCase()
    }
}