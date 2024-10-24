package creationalPatterns.prototype

import java.awt.Color


data class TextStyle(
    val fontSize: Int,
    val fontWeight: Int,
    val fontFamily:String,
    val textAlign: Int,
    val color: Color
){

}
//vi du
data class User(val firstName: String, val lastName: String){
    fun getFullName()="$firstName $lastName"
}

fun main()
{
    val defaultTextStyle = TextStyle(
        fontSize = 12, fontFamily = "bold",
        fontWeight = 23, textAlign = 1,
        color = Color.RED
    )
    // vi du toi co 100 cai va muon moi cai co fontSize khac nhau thi chang le toi tao 100 cai ?
    // moi cai giong nhau nhung khac fontSize thi sao ?
    //font size = 8
    val smallTextStyle = defaultTextStyle.copy(fontSize = 8)

    // Ví dụ tạo 100 TextStyle với fontSize khác nhau
    val textStyles = (1..10).map { size ->
        defaultTextStyle.copy(fontSize = size)
    }

    // In ra fontSize của các TextStyle đã tạo
    textStyles.forEach {
        println("TextStyle with fontSize: ${it.fontSize}")
    }

    val admin = User("Bold", "Lum")
    val student = admin.copy(firstName = "Thien", lastName = "Ngo")

    println("Admin: ${admin.lastName} ${admin.firstName} & Student: ${student.getFullName()}")

}
