# Library Management System

## Mô tả
Hệ thống Quản lý Thư viện (Library Management System) là một ứng dụng quản lý thư viện cơ bản được xây dựng bằng **Java Swing** và sử dụng **MySQL** để lưu trữ dữ liệu. Dự án hỗ trợ người dùng quản lý sách, độc giả và các giao dịch mượn/trả một cách hiệu quả, đồng thời cung cấp giao diện thân thiện để sử dụng trên máy tính cá nhân.

---

## Chức năng

### Đối với Nhân viên:
- **Đăng nhập**, đổi mật khẩu.
- **Quản lý sách**: Thêm, sửa, xóa, tìm kiếm thông tin sách.
- **Quản lý sinh viên**: Thêm, sửa, xóa, tìm kiếm thông tin sinh viên.
- **Quản lý mượn, trả sách**:
  - Theo dõi trạng thái mượn/trả sách.
  - Xem các trường hợp trễ hạn.
- **Quản lý lịch sử hoạt động**:
  - Xem chi tiết thông tin sách và lịch sử mượn, trả sách của sinh viên.
- **Quản lý danh sách sinh viên chưa trả sách**:
  - Xem danh sách sinh viên chưa trả sách đúng hạn.

### Đối với Admin:
- **Đăng nhập**.
- **Quản lý nhân viên**:
  - Cấp tài khoản cho nhân viên (thêm, sửa, xóa, xem thông tin nhân viên).

---

## Hướng dẫn cài đặt

### 1. Yêu cầu
- Cài đặt **Java** và **MySQL** trên máy tính.

2. **Clone repo**:
   ```bash
   git clone https://github.com/tkhan2004/Library-Management-.git
3. **Cài đặt cơ sở dữ liệu:** Tạo cơ sở dữ liệu tên library_ms và import file library.sql đã có trong folder database.
4. **Chạy ứng dụng:** 
Sử dụng IDE (netbeans hoặc intelliJ) để mở dự án.
Thêm những file thư viện (.jar) có sẵn trong folder (SrcThuVien) vào dự án.
Cuối cùng là chạy ứng dụng bằng file main.java hoặc vào folder dist để chọn file Library-management.jar.
Đăng nhập:
Sử dụng tài khoản mẫu:
-Nhân viên : tk: truc / mk : 1
-Admin : tk: khang / mk :1
## Danh Sách Thành Viên
| Tên            | Vai Trò             |
|-----------------|---------------------|
| Nguyễn Thanh Khang    | Tạo trang chức năng đăng nhập (admin, nhân viên), quản lý nhân viên, Đổi mật khẩu nhân viên, Chỉnh sửa giao diện          |
| Nguyễn Minh Trực      | Thiết kế trang chủ, Chức năng thống kê, Quản lý sách, Quản lý sinh viên, Chỉnh sửa giao diện | 
| Nguyễn Tấn Đồng       | Chức năng quản lý sinh viên chưa trả sách đúng hạn, chức năng xem chi tiêt thông tin sách, Đăng xuất |
| Nguyễn Gia Cường      | Chức năng quản lý mượn sách, trả sách, Quản lý theo dõi lịch sử mượn/trả sách | 
