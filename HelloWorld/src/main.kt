/*
this functionality is also available in functions
in return types we can use Void , Unit (Unit maps to Void)

we can use ? question mark at the end of return type. of a function
https://www.baeldung.com/kotlin-void-type
https://stackoverflow.com/questions/34342413/what-is-the-kotlin-double-bang-operator
 */



/*
Null can not be a value of a non-null type String

fun function1(email: String) {
    var email2: String
    email2 = null
    println(email2)
}

*/


/*


Now you can prevent that by adding a question mark to the String type to make it nullable.

fun function2(email: String) {
    var email2: String?
    email2 = null
    println(email2)
}

 */

/*
Now if we want the function to throw an exception when the value of email is null, we can add two exclamations at the end of email. Like this


fun function4(args: Array<String>) {
    var email: String?
    email = null
    println(email!!)
}


 */

/*
fun main(args: Array<String>) {
    var email: String?
    email = null
    println(email!!)
}

This will throw a KotlinNullPointerException
 */



fun main(args:Array<String>){
    //this is the main function

    //var used to create variable
    //val is a constant, its value cant be changed.

    var x:Int=4
    var y:String="sample string"

    //val z:Int=20
    //z=25//val cannot be reassigned

    println(x)
    println(y)



    //Null Pointer Exception NPE example


    //var nullVarEx:Int=null//Null cannot be a value of non-null type int

    //var nullVarEx:Int?=(int)readLine()//dont do it type cast way , there's a function in kotlin

    //you have to add question marks everywhere for null safety :D after data var types and after functions
    println("Enter a Number")
    var num1:Int = readLine()!!.toInt()
    println("Enter a Number")
    var num2:Int = readLine()!!.toInt()

    val num3 = num1+num2
    //https://www.baeldung.com/kotlin-concatenate-strings
    /*
    @Test
fun givenTwoStrings_concatenateWithPlusMethod_thenEquals() {
    val a = "Hello"
    val b = "Baeldung"
    val c = a.plus(" ").plus(b)

    assertEquals("Hello Baeldung", c)
}


     */

/*

@Test
fun givenTwoStrings_concatenateWithPlusOperator_thenEquals() {
    val a = "Hello"
    val b = "Baeldung"
    val c = a + " " + b

    assertEquals("Hello Baeldung", c)
}

 */
    println("addition of num1 and num2 is ".plus(num3))
    //If we don't need the value NULL anywhere inside our project.. then we should use !!
    //THIS WILL ASK FOR NULL POINTER EXCEPTION EXPLICITLY.

    //The third option is for NPE-lovers: the not-null assertion operator (!!) converts any value to a non-null type and throws an exception if the value is null. We can write b!!, and this will return a non-null value of b (e.g., a String in our example) or throw an NPE if b is null:


/*
    var email2: String?
    email2 = null
    println(email2!!)
    /*
    Exception in thread "main" kotlin.KotlinNullPointerException
	at MainKt.main(main.kt:81)
     */
*/




}

/*
Null Safety
Nullable types and Non-Null Types

Kotlin's type system is aimed at eliminating the danger of null references from code, also known as the The Billion Dollar Mistake.

One of the most common pitfalls in many programming languages, including Java, is that accessing a member of a null reference will result in a null reference exception. In Java this would be the equivalent of a NullPointerException or NPE for short.

Kotlin's type system is aimed to eliminate NullPointerException's from our code. The only possible causes of NPE's may be:

    An explicit call to throw NullPointerException();
    Usage of the !! operator that is described below;
    Some data inconsistency with regard to initialization, such as when:
        An uninitialized this available in a constructor is passed and used somewhere ("leaking this");
        A superclass constructor calls an open member whose implementation in the derived class uses uninitialized state;
    Java interoperation:
        Attempts to access a member on a null reference of a platform type;
        Generic types used for Java interoperation with incorrect nullability, e.g. a piece of Java code might add null into a Kotlin MutableList<String>, meaning that MutableList<String?> should be used for working with it;
        Other issues caused by external Java code.

In Kotlin, the type system distinguishes between references that can hold null (nullable references) and those that can not (non-null references). For example, a regular variable of type String can not hold null:


var a: String = "abc" // Regular initialization means non-null by default
a = null // compilation error

To allow nulls, we can declare a variable as nullable string, written String?:

var b: String? = "abc" // can be set null
b = null // ok
print(b)


Now, if you call a method or access a property on a, it's guaranteed not to cause an NPE, so you can safely say:

val l = a.length

But if you want to access the same property on b, that would not be safe, and the compiler reports an error:

val l = b.length // error: variable 'b' can be null

But we still need to access that property, right? There are a few ways of doing that.
Checking for null in conditions

First, you can explicitly check if b is null, and handle the two options separately:

val l = if (b != null) b.length else -1

The compiler tracks the information about the check you performed, and allows the call to length inside the if. More complex conditions are supported as well:


val b: String? = "Kotlin"
if (b != null && b.length > 0) {
    print("String of length ${b.length}")
} else {
    print("Empty string")
}

Note that this only works where b is immutable (i.e. a local variable which is not modified between the check and the usage or a member val which has a backing field and is not overridable), because otherwise it might happen that b changes to null after the check.
Safe Calls

Your second option is the safe call operator, written ?.:

val a = "Kotlin"
val b: String? = null
println(b?.length)
println(a?.length) // Unnecessary safe call



This returns b.length if b is not null, and null otherwise. The type of this expression is Int?.

Safe calls are useful in chains. For example, if Bob, an Employee, may be assigned to a Department (or not), that in turn may have another Employee as a department head, then to obtain the name of Bob's department head (if any), we write the following:

bob?.department?.head?.name

Such a chain returns null if any of the properties in it is null.

To perform a certain operation only for non-null values, you can use the safe call operator together with let:

val listWithNulls: List<String?> = listOf("Kotlin", null)

for (item in listWithNulls) {

    item?.let { println(it) } // prints Kotlin and ignores null

}




A safe call can also be placed on the left side of an assignment. Then, if one of the receivers in the safe calls chain is null, the assignment is skipped, and the expression on the right is not evaluated at all:

// If either `person` or `person.department` is null, the function is not called:

person?.department?.head = managersPool.getManager()



Elvis Operator

When we have a nullable reference b, we can say "if b is not null, use it, otherwise use some non-null value":

val l: Int = if (b != null) b.length else -1

Along with the complete if-expression, this can be expressed with the Elvis operator, written ?::

val l = b?.length ?: -1

If the expression to the left of ?: is not null, the elvis operator returns it, otherwise it returns the expression to the right. Note that the right-hand side expression is evaluated only if the left-hand side is null.

Note that, since throw and return are expressions in Kotlin, they can also be used on the right hand side of the elvis operator. This can be very handy, for example, for checking function arguments:

fun foo(node: Node): String? {

    val parent = node.getParent() ?: return null

    val name = node.getName() ?: throw IllegalArgumentException("name expected")

    // ...

}



The !! Operator

The third option is for NPE-lovers: the not-null assertion operator (!!) converts any value to a non-null type and throws an exception if the value is null. We can write b!!, and this will return a non-null value of b (e.g., a String in our example) or throw an NPE if b is null:

val l = b!!.length

Thus, if you want an NPE, you can have it, but you have to ask for it explicitly, and it does not appear out of the blue.
Safe Casts

Regular casts may result into a ClassCastException if the object is not of the target type. Another option is to use safe casts that return null if the attempt was not successful:

val aInt: Int? = a as? Int

Collections of Nullable Type

If you have a collection of elements of a nullable type and want to filter non-null elements, you can do so by using filterNotNull:

val nullableList: List<Int?> = listOf(1, 2, null, 4)

val intList: List<Int> = nullableList.filterNotNull()

--End Null Safety








 */