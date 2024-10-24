package creationalPatterns.adapter

import java.awt.Point

fun main() {
    // Tạo một đối tượng TextView cụ thể
    val textView = TextViewImpl()

    // Tạo một adapter cho TextView
    val shapeAdapter = ShapeAdapter(textView)

    // Sử dụng adapter để lấy bounding box
    shapeAdapter.boundingBox(Point(0, 0), Point(100, 100))

    // Sử dụng manipulator để thực hiện thao tác
    val manipulator = shapeAdapter.createManipulator()
    manipulator.manipulate()
}

// Giao diện Shape định nghĩa các phương thức cần thiết cho hình dạng
interface Shape {
    fun boundingBox(bottomLeft: Point, topRight: Point)
    fun createManipulator(): Manipulator
}

// Lớp trừu tượng TextView với các phương thức cần thiết
abstract class TextView {
    // Phương thức để thiết lập vị trí gốc
    fun getOrigin(x: Int, y: Int) {
        println("Origin set to: ($x, $y)")
    }

    // Phương thức để thiết lập kích thước
    fun getExtend(width: Int, height: Int) {
        println("Extend set to: Width = $width, Height = $height")
    }

    // Phương thức trừu tượng để kiểm tra xem TextView có rỗng hay không
    abstract fun isEmpty(): Boolean
}

// Lớp cụ thể TextViewImpl triển khai các phương thức từ TextView
class TextViewImpl : TextView() {
    // Triển khai phương thức isEmpty() để trả về false
    override fun isEmpty(): Boolean {
        return false // Ví dụ đơn giản trả về false
    }
}

// Lớp Manipulator mô phỏng hành động cho các hình dạng
class Manipulator {
    // Phương thức để thực hiện thao tác
    fun manipulate() {
        println("Manipulating the shape...")
    }
}

// Lớp Adapter kết nối giữa TextView và Shape
class ShapeAdapter(private val textView: TextView) : Shape {
    // Triển khai phương thức boundingBox để sử dụng TextView
    override fun boundingBox(bottomLeft: Point, topRight: Point) {
        // Sử dụng TextView để thiết lập vị trí và kích thước
        textView.getOrigin(bottomLeft.x, bottomLeft.y)
        textView.getExtend(topRight.x - bottomLeft.x, topRight.y - bottomLeft.y)
    }

    // Triển khai phương thức createManipulator để tạo một đối tượng Manipulator
    override fun createManipulator(): Manipulator {
        return Manipulator() // Trả về một đối tượng Manipulator
    }
}
