# Kotlin Design Patterns
## Overview
Design Patterns là những giải pháp tái sử dụng cho các vấn đề phổ biến trong phát triển phần mềm. 
Chúng giúp mã nguồn dễ bảo trì, mở rộng và giảm sự phụ thuộc giữa các thành phần. 
Dưới đây là các ví dụ đã thực hiện cho Adapter Pattern, Observer Pattern, và Prototype Pattern.

## Example
###  1. Adapter Pattern
Khái niệm: Adapter Pattern cho phép kết nối các lớp có giao diện không tương thích bằng cách cung cấp một lớp "adapter" để chuyển đổi giữa hai giao diện khác nhau.

- Mục đích: Giúp các lớp không tương thích làm việc cùng nhau mà không cần thay đổi mã nguồn của chúng.
- Ví dụ: Chuyển đổi định dạng dữ liệu: Một lớp nhận dữ liệu ở định dạng XML nhưng cần cung cấp dữ liệu ở định dạng JSON. Ta có thể sử dụng một adapter để chuyển đổi giữa hai định dạng này.
### 2. Observer Pattern
Khái niệm: Observer Pattern cho phép một đối tượng (Subject) thông báo cho nhiều đối tượng khác (Observers) khi có sự thay đổi trạng thái, nhằm đảm bảo rằng tất cả các observers đều được cập nhật.

- Mục đích: Giúp duy trì đồng bộ giữa các đối tượng mà không cần phải biết nhau, từ đó làm giảm độ kết nối giữa chúng.
- Ví dụ: Danh sách phim yêu thích: Khi người dùng thêm hoặc xóa phim trong danh sách yêu thích, tất cả các thành phần giao diện liên quan (như biểu đồ thống kê) sẽ tự động cập nhật để phản ánh thay đổi này.
### 3.Prototype
Khái niệm: Prototype Pattern cho phép tạo ra các đối tượng mới bằng cách sao chép một đối tượng hiện có (prototyping) thay vì khởi tạo một đối tượng mới từ đầu.

- Mục đích: Giảm thiểu chi phí tạo ra đối tượng mới, đặc biệt khi việc khởi tạo là tốn kém hoặc phức tạp.
- Ví dụ: Thiết lập kiểu chữ: Khi có một kiểu chữ mặc định, bạn có thể sao chép nó và chỉ thay đổi một số thuộc tính như kích thước chữ hay màu sắc để tạo ra các kiểu chữ mới mà không cần phải tạo từ đầu.
## Kết luận
Việc hiểu rõ và áp dụng các design pattern như Adapter, Observer, và Prototype giúp bạn viết mã nguồn có cấu trúc hơn, dễ bảo trì hơn và mở rộng hơn. Những pattern này không chỉ giúp giải quyết các vấn đề phổ biến mà còn cải thiện khả năng tái sử dụng mã nguồn trong các dự án lớn.


