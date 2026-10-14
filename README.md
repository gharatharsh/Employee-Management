# Employee Management System

![Java](https://img.shields.io/badge/Java-17+-orange?logo=openjdk&logoColor=white)
![Servlets](https://img.shields.io/badge/Java-Servlets-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-336791?logo=postgresql&logoColor=white)
![Tomcat](https://img.shields.io/badge/Apache-Tomcat-F8DC75?logo=apachetomcat&logoColor=black)
![License](https://img.shields.io/badge/Purpose-Educational-green)

A web-based application to manage employee records, built with **Java Servlets**, **JDBC**, and **PostgreSQL**. It supports full CRUD operations (Create, Read, Update, Delete) through a simple browser interface.

---

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Database Setup](#database-setup)
- [How It Works](#how-it-works)
- [What I Learned](#what-i-learned)
- [Future Improvements](#future-improvements)
- [Author](#author)

---

## Features

- **Add** new employee records
- **View** all employees or individual details
- **Update** existing employee information
- **Delete** employee records
- **Persistent storage** using PostgreSQL
- **Server-side request handling** using Java Servlets

---

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java, Java Servlets |
| Database Access | JDBC |
| Database | PostgreSQL |
| Frontend | HTML, CSS |
| Server | Apache Tomcat |
| IDE | Eclipse / IntelliJ IDEA |

---

## Project Structure

> Update this to match your actual folders.

```
EmployeeManagementSystem/
├── src/
│   └── com/employee/
│       ├── AddEmployeeServlet.java
│       ├── ViewEmployeeServlet.java
│       ├── UpdateEmployeeServlet.java
│       ├── DeleteEmployeeServlet.java
│       └── DBConnection.java
├── WebContent/
│   ├── index.html
│   ├── addEmployee.html
│   └── WEB-INF/
│       └── web.xml
└── README.md
```

---

## Getting Started

### Prerequisites

- JDK 11 or higher
- Apache Tomcat 9 or higher
- PostgreSQL
- PostgreSQL JDBC driver (add the `.jar` to `WEB-INF/lib`)
- Eclipse or IntelliJ IDEA

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/<repo-name>.git
   ```
2. **Import the project** into Eclipse or IntelliJ as a Dynamic Web Project.
3. **Add the PostgreSQL JDBC driver** to `WEB-INF/lib`.
4. **Set up the database** (see below).
5. **Update the database credentials** in `DBConnection.java`:
   ```java
   String url = "jdbc:postgresql://localhost:5432/your_db_name";
   String user = "your_username";
   String password = "your_password";
   ```
6. **Deploy on Tomcat** and start the server.
7. **Open in browser:**
   ```
   http://localhost:8080/<project-name>/
   ```

---

## Database Setup

Create the database and table in PostgreSQL (adjust the columns to match your project):

```sql
CREATE DATABASE employee_db;

CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department VARCHAR(50),
    salary NUMERIC(10, 2)
);
```

---

## How It Works

```
Browser (HTML form)
        |
        v
  Java Servlet  -->  processes the request
        |
        v
      JDBC      -->  runs SQL queries
        |
        v
   PostgreSQL   -->  stores and returns data
        |
        v
  Servlet sends the response back to the browser
```

---

## What I Learned

- Java Servlet lifecycle and request/response handling
- Connecting a Java application to a database using JDBC
- Executing SQL queries (INSERT, SELECT, UPDATE, DELETE) from Java
- Integrating a web application with a relational database
- Deploying servlet-based applications on Apache Tomcat

---

## Future Improvements

- Login and authentication for admins
- Input validation and better error messages
- Search and filter employees
- Use `PreparedStatement` everywhere to prevent SQL injection
- Migrate to Spring Boot and Hibernate

---

## Author

**Harsh Gharat**
[LinkedIn](www.linkedin.com/in/harsh-gharat) | [GitHub](https://github.com/gharatharsh)

---

## License

This project was created for educational and learning purposes.
