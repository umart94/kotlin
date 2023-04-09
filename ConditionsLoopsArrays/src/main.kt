/**
 *main.kt created by umartariq on 08/06/2020
 *1:41 PM
 */

fun main(args: Array<String>){

    println("Enter marks")
    var marks:Int = readLine()!!.toInt()
    if(marks>=50){
        println("Pass")
    }
    else
    {
        println("Fail")

    }

    //when -> switch
    println("Enter number")
    var x:Int = readLine()!!.toInt()
    when(x){
        10 -> println("A")
        9 -> println("B")
        8 -> println("C")
        7 -> println("D")
        in 1..6 -> println("F")
        else -> println("you calculated incorrectly")
    }

    //for & while loops

    var x2:Int=1
    while(x2<=10){
        println(x2)
        x2++
    }

    for(x3 in 1..10){
        println(x3)
    }

    for(x4 in 10 downTo 1){
        println(x4)
    }

    for(x5 in 1..10 step 4){//<=10 prints 1,5,9
        println(x5)
    }

    //arrays
    //3 types of arrays array,list,hashmap

    var DesktopPCCompanies = arrayOf("Intel","AMD","VIA","IBM")
    var mobileCPUCompanies = arrayOf("QualcommSnapdragon","MediaTek","Spreadtrum","IntelAtom","MarvellPXA","NvidiaTegra","SamsungExynos",
        "HuaweiHiSilicon","Allwinner","Rockchip","SamsungExynos")

    for(x6 in mobileCPUCompanies) {
    //    println(x6.toString())
    }

    var mobileCPUCompaniesArrayList = ArrayList<String>()
    var list: MutableList<String> = arrayListOf("QualcommSnapdragon","MediaTek","Spreadtrum","IntelAtom","MarvellPXA","NvidiaTegra","SamsungExynos",
        "HuaweiHiSilicon","Allwinner","Rockchip","SamsungExynos")
    list.addAll(DesktopPCCompanies)
    for( x7 in list){
        println(x7)
    }

    //hashmap key value pairs
    var emp = HashMap<String,Int>()
    emp.put("A",19876)
    emp.put("B",9876)
    emp.put("C",8765)
    emp.put("D",7654)
    emp.put("E",6543)
    emp.put("F",500)

    for(x8 in emp.keys){
        println(x8.plus("    has salary of     ").plus(emp[x8]))
    }



}