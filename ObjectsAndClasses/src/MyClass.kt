/**
 *MyClass.kt created by umartariq on 08/06/2020
 *3:58 PM
 */

open class MyClass{
    var studentno:Int=0
    var name:String=""
    private var marks:Double
    private set

    constructor(){
        studentno = 100
        name = "Enter Name"
        marks = 49.999999999999999999999999999999999999999999999999999999999999999999999
    }
    fun display(){
        val ParentClassName = MyClass::class.qualifiedName;
        println("Inside ParentClass Class, display function ... name of this class is ".plus(ParentClassName.toString()))
        println(name)
        println(marks)
    }

    fun getMarks() : Double{
        return marks
    }
    fun setMarks(a : Double){
        marks = a
    }

    fun add(x:Int,y:Int){
        println(x+y)
    }

    fun add(x:Int,y:Int,z:Int){
        println(x+y+z)
    }

    open fun overriddenFunction(){
        val rnds22 = (0..9876).random()
        val ParentClassName2 =MyClass::class.qualifiedName;
        println("Inside ParentClass Class , overridden function... name of this class is ".plus(ParentClassName2.toString()).plus("         ").plus(rnds22))


       
    }

}


//: INSTEAD OF EXTENDS

//this type is final so it cannot be inherited from (MyClass)

//make class open

class SubClass : MyClass(){

    fun showSomeMessage(){
        val SubClassName =SubClass::class.qualifiedName;
        println("Inside SubClass Class , showSomeMessageFunction function... name of this class is ".plus(SubClassName.toString()))

    }

    //overriddenFunction() in MyClass is final and cannot be overridden
    //use open in baseclass and override keyword in subclass
    override fun overriddenFunction(){
        val rnds = (0..990).random()
        val SubClassName2 =SubClass::class.qualifiedName;
        println("Inside SubClass Class , overriddenFunction function... name of this class is ".plus(SubClassName2.toString().plus("               ").plus(rnds)))

    }


}


class VarExamples{

    var dynamicVariableX:Int=0 //dynamic variable

    companion object{
        var staticVariableS:Int=0 // static variable
    }
}






//main function will be outside the class
fun main(args:Array<String>){

    var defaultStudentObject = MyClass()
    defaultStudentObject.display()

    var studentObject  = MyClass() // no new keyword.. just assign class name to your object
    studentObject.name = "Umar"
    studentObject.setMarks(80.7123456789999999988898989898)
    studentObject.display()

    var topperObject = MyClass()
    topperObject.name = "Topper"
    topperObject.setMarks(999999.99999999999999999999999999999999999999999999999999999999999999999999)
    topperObject.studentno = 1
    println(topperObject.name)
    println(topperObject.studentno)
    println(topperObject.getMarks())


    var additionOverload = MyClass()
    additionOverload.add(4,5)
    additionOverload.add(6,7,8)

    println("***************************************************")
    var parentObject = MyClass()
    parentObject.display()
    //parentObject.showSomeMessage()//cant access child method
    println("***************************************************")
    var childObject = SubClass()
    childObject.display() //access base class method from child
    childObject.showSomeMessage()
    println("***************************************************")



    println(" |   |    |    |   |     |    |    |     |     |     |    ")
    var BaseClassObject = MyClass()
    BaseClassObject.overriddenFunction()
    var SubClassObject = SubClass()
    SubClassObject.overriddenFunction()
    println(" |   |    |    |   |     |    |    |     |     |     |    ")


    var varexamples = VarExamples()
    varexamples.dynamicVariableX++
    println("dynamic variable" + varexamples.dynamicVariableX)

    var secondvarexamplesobject = VarExamples()
    secondvarexamplesobject.dynamicVariableX++
    println("dynamic variable" + secondvarexamplesobject.dynamicVariableX)

    //each object has a seperate copy of dynamicVariableX

    //but for static variable , we dont need class instance, just class name and access modifier
    VarExamples.staticVariableS++
    VarExamples.staticVariableS++
    println("static variable" + VarExamples.staticVariableS)


}