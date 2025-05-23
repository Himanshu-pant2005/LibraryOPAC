# LibraryOPAC
# 📚 Library OPAC Java Project

This is a simple **Library OPAC (Online Public Access Catalog)** application developed in **Java** using **AWT/Swing** for GUI and **JDBC** for MySQL database connectivity. It allows users to search for books by title and author and displays whether the book is available in the database.

---

## 🔧 Tech Stack

- **Java (JDK 17)**
- **AWT/Swing** – for the GUI
- **JDBC** – for database connectivity
- **MySQL** – backend relational database
- **IntelliJ IDEA** – IDE used for development

---

## 📁 Project Structure

LibraryOPAC/   
├── src/   
│ ├── Book.java # POJO for book data   
│ ├── DatabaseConnection.java # Handles JDBC connection  
│ └── OPACInterface.java # Main GUI and logic  
├── README.md # Project documentation  

---



## 🗃️ Database Configuration

Create a MySQL database named `library_db` with the following table:

```sql
CREATE DATABASE library_db;

USE library_db;

CREATE TABLE books (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255),
  author VARCHAR(255),
  year INT
);
```
---
## 🖥️ How to Run   
1. Clone the repository:

```
git clone https://github.com/yourusername/LibraryOPAC.git
cd LibraryOPAC
```

2. Open the project in IntelliJ IDEA.

3. Ensure the following:

    - JDK 17 is selected in Project SDK.

    - JDBC MySQL Driver is added to your classpath.

4. Run OPACInterface.java.

---

## 🔍 Features
- Search for books using Title and Author fields.

- Displays book ID and availability status.

- Simple and intuitive GUI using Java AWT/Swing.

- Secure and efficient database querying with PreparedStatement.

---

## 📷 Screenshots
### 🔍 Book Search Window

![Book Search Window](Image/GUI.png)

### ✅ Book Found Output

![Book Available Message](Image/Book found.png)

### ❌ Book Not Found Output

![Book Not Available Message](Image/Not Found.png)
