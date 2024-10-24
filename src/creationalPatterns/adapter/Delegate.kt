package creationalPatterns.adapter

fun main() {
    // Tạo một đối tượng XMLDataProvider để cung cấp dữ liệu XML
    val xmlDataProvider = XMLDataProvider()

    // Tạo một DataAdapter để chuyển đổi dữ liệu XML thành JSON
    val adapter = DataAdapter(xmlDataProvider)

    // Sử dụng adapter để lấy dữ liệu JSON
    val jsonData = adapter.provideJsonData()

    // In ra dữ liệu JSON
    println("JSON Data: $jsonData") // Kết quả sẽ là: JSON Data: {"name":"thien"}
}

// Giao diện định nghĩa phương thức cung cấp dữ liệu JSON
interface JsonDataProvider {
    fun provideJsonData(): String
}

// Lớp cung cấp dữ liệu dưới dạng XML
class XMLDataProvider {
    fun provideXML(): String {
        return "<name>thien</name>" // Trả về chuỗi XML
    }
}

// Lớp Adapter chuyển đổi dữ liệu XML thành JSON
class DataAdapter(private val xmlDataProvider: XMLDataProvider) : JsonDataProvider {
    override fun provideJsonData(): String {
        // Lấy dữ liệu XML từ XMLDataProvider
        val xmlData = xmlDataProvider.provideXML()

        // Phân tích XML (có thể sử dụng thư viện để phân tích, ở đây đơn giản hóa)
        val name = "thien" // Ở đây bạn có thể phân tích XML nếu cần

        // Trả về dữ liệu ở định dạng JSON
        return "{\"name\":\"$name\"}" // Định dạng JSON
    }
}
