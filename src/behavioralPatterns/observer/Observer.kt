package behavioralPatterns.observer

// Dữ liệu phim yêu thích
data class FavoritesFilm(val type: String, val percentage: Float)

// Giao diện Observer để nhận thay đổi từ Subject
interface Observer<T> {
    fun onChanged(data: T)
}

// Subject dùng để quản lý và thông báo thay đổi dữ liệu
class Subject<T>(initialValue: T) {
    private val observers = mutableListOf<Observer<T>>()
    var value: T = initialValue
        set(newValue) {
            field = newValue
            notifyObservers() // Thông báo khi dữ liệu thay đổi
        }

    // Thêm observer vào danh sách
    fun addObserver(observer: Observer<T>) {
        observers.add(observer)
    }

    // Thông báo cho tất cả observers
    private fun notifyObservers() {
        for (observer in observers) {
            observer.onChanged(value)
        }
    }
}

// ViewModel quản lý dữ liệu phim
class ViewModel {
    // Subject quản lý danh sách phim yêu thích
    val listFavorites = Subject<List<FavoritesFilm>>(emptyList())

    // Hàm fetch để tải dữ liệu và thông báo observers
    fun fetch() {
        val list = listOf(
            FavoritesFilm("Action", 50f),
            FavoritesFilm("Comedy", 20f)
        )
        listFavorites.value = list // Cập nhật giá trị và thông báo observers
    }
    fun register(observer: Observer<List<FavoritesFilm>>) {
        listFavorites.addObserver(observer)
    }
}

// SpreadSheet triển khai Observer và Chart để hiển thị dữ liệu dưới dạng bảng
class SpreadSheet(viewModel: ViewModel) : Observer<List<FavoritesFilm>> {
    init {
        viewModel.listFavorites.addObserver(this) // Đăng ký làm observer
    }

    // Nhận thông báo khi dữ liệu thay đổi
    override fun onChanged(data: List<FavoritesFilm>) {
        draw(data) // Vẽ lại dữ liệu
    }

    // Vẽ bảng hiển thị dữ liệu
    fun draw(data: List<FavoritesFilm>) {
        println("SpreadSheet: Hiển thị dữ liệu $data")
    }
}

// BarChart triển khai Observer và Chart để hiển thị dữ liệu dưới dạng biểu đồ
class BarChart(viewModel: ViewModel) : Observer<List<FavoritesFilm>> {
    init {
        viewModel.listFavorites.addObserver(this) // Đăng ký làm observer
    }

    // Nhận thông báo khi dữ liệu thay đổi
    override fun onChanged(data: List<FavoritesFilm>) {
        draw(data) // Vẽ lại dữ liệu
    }

    // Vẽ biểu đồ cột hiển thị dữ liệu
    fun draw(data: List<FavoritesFilm>) {
        println("BarChart: Hiển thị biểu đồ cho dữ liệu $data")
    }
}

// Hàm main để kiểm tra chương trình
fun main() {
    val viewModel = ViewModel() // Khởi tạo ViewModel

    val spreadSheet = SpreadSheet(viewModel) // Tạo bảng SpreadSheet
    val barChart = BarChart(viewModel) // Tạo biểu đồ BarChart

    viewModel.fetch() // Lấy dữ liệu và thông báo các observers
}
