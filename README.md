# Ani Review - JSP/Servlet Demo Project

## Giới thiệu

Đây là project **demo** nhằm mục đích:

* Ôn tập và củng cố kiến thức về **JSP & Servlet**
* Áp dụng mô hình **MVC (Model - View - Controller)**
* Thực hành **phân quyền (Authorization)** và **phân trang (Pagination)**
* Kết hợp **Java + JavaScript** trong phát triển web

---

## ⚙️ Công nghệ sử dụng

![Java](https://img.shields.io/badge/java-8-%23ED8B00.svg?style=for-the-badge\&logo=openjdk\&logoColor=white)
![JSP](https://img.shields.io/badge/jsp-%23007396.svg?style=for-the-badge\&logo=java\&logoColor=white)
![Servlet](https://img.shields.io/badge/servlet-%23F89820.svg?style=for-the-badge\&logo=java\&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge\&logo=javascript\&logoColor=%23F7DF1E)
![JSTL](https://img.shields.io/badge/jstl-%23007396.svg?style=for-the-badge\&logo=java\&logoColor=white)
![SiteMesh](https://img.shields.io/badge/sitemesh-%23000000.svg?style=for-the-badge)
![MySQL](https://img.shields.io/badge/mysql-8.0-%234479A1.svg?style=for-the-badge\&logo=mysql\&logoColor=white)
![JDBC](https://img.shields.io/badge/jdbc-%23007396.svg?style=for-the-badge\&logo=java\&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-8.5-%23F8DC75.svg?style=for-the-badge\&logo=apache-tomcat\&logoColor=black)
![Postman](https://img.shields.io/badge/Postman-API%20Testing-FF6C37?style=for-the-badge\&logo=postman\&logoColor=white)


---

## 🏗️ Kiến trúc hệ thống

Project được xây dựng theo mô hình **MVC**:

* **Model**: xử lý dữ liệu, tương tác database
* **View (JSP)**: hiển thị giao diện người dùng
* **Controller (Servlet)**: xử lý request/response

Ngoài ra project áp dụng:

* 🔐 Phân quyền user (admin / user)
* 📄 Phân trang dữ liệu (paging)

---

## 📦 Cấu trúc thư mục (tham khảo)

## 📂 Project Structure

```
src/main/
├── java/com/reviewanime/
│   ├── constant/
│   ├── controller/
│   ├── dao/
│   ├── filter/
│   ├── mapper/
│   ├── model/
│   ├── paging/
│   ├── service/
│   ├── sort/
│   └── utils/
│
├── resources/
│   ├── db.properties
│   └── message.properties
│
└── webapp/
    ├── WEB-INF/
    ├── common/
    ├── decorators/
    ├── template/
    ├── views/
    └── index.jsp
```

---

## 🚀 Cách chạy project

### 1. Yêu cầu

* JDK 8
* Apache Tomcat 8.5
* MySQL
* Maven

---

### 2. Clone project

```bash
git clone https://github.com/quocnguyen1249/ani-review.git
```
## 🚀 Cách chạy project

### 1. Yêu cầu môi trường

* JDK 8
* Apache Tomcat 8.5
* MySQL
* Maven

---

### 2. Clone project

```bash id="cln123"
git clone https://github.com/quocnguyen1249/ani-review.git
```

---

### 3. Cấu hình database

#### Tạo database:

```sql id="db123"
CREATE DATABASE reviewanime;
```

#### Import dữ liệu:

Chạy lần lượt 3 file trong thư mục `database/`:

```text id="imp123"
create_table.sql   -> tạo bảng
insert_table.sql   -> dữ liệu ban đầu
sample_data.sql    -> dữ liệu mẫu
```

---

### 4. Cấu hình kết nối database

Mở file `src/main/resources/db.properties` và cập nhật:

```properties id="cfg123"
driverName = com.mysql.jdbc.Driver
url = jdbc:mysql://localhost:3306/reviewanime
user = your_username
password = your_password
```

---

### 5. Build project

```bash id="bld123"
mvn clean install
```

---

### 6. Deploy lên Tomcat

* Import project vào IntelliJ / Eclipse
* Add server **Tomcat v8.5 Server at localhost-config**
* Deploy file `.war`

---

### 7. Truy cập hệ thống

```text id="url123"
http://localhost:8080/ani-review
```


---

## 🧪 Test API

Sử dụng ![Postman](https://img.shields.io/badge/Postman-API%20Testing-FF6C37?style=for-the-badge\&logo=postman\&logoColor=white) để test các API:

* Login / Logout
* CRUD dữ liệu
* Phân trang
* thêm / sửa / xóa
---

## 📚 Mục tiêu học tập

* Hiểu rõ luồng hoạt động của **Servlet**
* Nắm vững cách tổ chức project theo **MVC**
* Làm quen với cách build & deploy ứng dụng Java Web

---

## 📌 Ghi chú

Đây là project mang tính **học tập và thực hành**, không phải sản phẩm nên có sai hay thiếu chổ nào mong mội người thông cảm.
