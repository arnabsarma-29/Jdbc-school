# School Management System (JDBC + Metadata Project)

A Java-based console application that manages students and teachers using JDBC. It supports CRUD operations, SQL joins, and database metadata inspection.

---

## Features

- Add, update, and delete students
- Add, update, and delete teachers
- View all records (Student / Teacher)
- Execute JOIN queries between Student and Teacher
- Display Database Metadata
- Display ResultSet Metadata
- PostgreSQL integration using JDBC

---

## Tech Stack

- Language: Java
- Database: PostgreSQL
- Connectivity: JDBC
- Concepts Used:
  - PreparedStatement
  - ResultSet
  - JOIN Queries
  - DatabaseMetaData
  - ResultSetMetaData

---

## Project Structure

```
com.jspider.school/

    Driver.java

    dao/
        Student_Dao.java
        Teacher_Dao.java

    model/
        Student.java
        Teacher.java

    database/
        Db_Connection.java
```

---

## How It Works

- The application starts from `Driver.java`
- Menu-driven console input using Scanner
- Student and Teacher modules are separated
- Each operation calls DAO methods
- DAO handles all database operations using JDBC

---

## Student Features

- Insert student
- Update class number
- Delete student
- Show all students
- Execute JOIN query with teacher
- View database and table metadata

---

## Teacher Features

- Insert teacher
- Update class number
- Delete teacher
- Show all teachers
- Execute JOIN query with students
- View database and table metadata

---

## Sample Queries Used

- Student JOIN Teacher:
```
select s.*, t.name as teacher_name 
from student s 
join teacher t 
on s.class_no = t.class_no
```

- Teacher JOIN Student:
```
select t.*, s.id, s.name 
from teacher t 
join student s 
on t.class_no = s.class_no
```

---

## Database Configuration

```
URL: jdbc:postgresql://localhost:5432/jdbc_school
Username: postgres
Password: 123
```

---

## Key Concepts Used

- JDBC (Java Database Connectivity)
- SQL JOIN operations
- DatabaseMetaData
- ResultSetMetaData
- DAO Pattern
- Console-based architecture
- Exception handling

---

## How to Run

1. Clone the repository
```
git clone https://github.com/your-username/school-jdbc-project.git
```

2. Import into IDE (Eclipse / IntelliJ)

3. Setup PostgreSQL database:
   - Create database: jdbc_school
   - Update credentials in Db_Connection.java

4. Run Driver.java

---

## Learning Outcome

This project demonstrates:
- How JDBC connects Java with databases
- How JOIN queries work in real systems
- How to inspect database structure using metadata
- How DAO pattern separates logic cleanly

---

## Author

https://github.com/arnabsarma-29
