
# **Shopping Cart Billing System**

## **Table of Contents**
1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Setup and Installation](#setup-and-installation)
5. [Usage](#usage)
6. [Database Structure](#database-structure)
7. [Sample Outputs](#sample-outputs)
8. [Future Enhancements](#future-enhancements)
9. [Contributors](#contributors)

---

## **Introduction**
The Shopping Cart Billing System is a Java-based project designed to handle online shopping workflows, including user login, product selection, billing, and order confirmation. It leverages Hibernate for database interaction and provides an efficient way to manage customer transactions.

---

## **Features**
- User authentication (login/logout).
- Product selection with real-time price calculation.
- Comprehensive billing process.
- Secure database interaction using Hibernate.
- Clear, user-friendly console-based interface.

---

## **Technologies Used**
- **Programming Language**: Java  
- **Database**: MySQL  
- **ORM Framework**: Hibernate  
- **Tools**:  
  - IDE: IntelliJ IDEA/Eclipse  
  - MySQL Workbench/CLI for database management  
  - Maven for dependency management  

---

## **Setup and Installation**

### **Prerequisites**
1. Install [Java 8 or higher](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Install [MySQL Server](https://dev.mysql.com/downloads/installer/).
3. Install [Maven](https://maven.apache.org/download.cgi).
4. Configure `JAVA_HOME` and `MAVEN_HOME` in your system’s environment variables.

### **Installation Steps**
1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-repository/shopping-cart-billing.git
   cd shopping-cart-billing
   ```
2. **Set Up Database**
   - Create a database named `User` using MySQL.
   - Execute the SQL script in `resources/db_setup.sql` to initialize tables.
   
3. **Configure Hibernate**
   Update the `hibernate.cfg.xml` file with your MySQL credentials:
   ```xml
   <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/User?createDatabaseIfNotExist=true</property>
   <property name="hibernate.connection.username">root</property>
   <property name="hibernate.connection.password">your_password</property>
   ```

4. **Run the Project**
   - Compile and package the project using Maven:
     ```bash
     mvn clean install
     ```
   - Execute the application:
     ```bash
     java -jar target/shopping-cart-billing-1.0.jar
     ```

---

## **Usage**
1. **Login**
   - Enter a valid phone number and password.
   - The system will validate your credentials.

2. **Product Selection**
   - Choose products by their IDs.
   - View cart details and confirm purchase.

3. **Billing**
   - See the total price, applicable discounts, and final amount.
   - Confirm your order for delivery.

4. **Exit**
   - After billing, the program exits with a thank-you message.

---

## **Database Structure**

### **Tables**
1. **Users**  
   Stores user information for authentication.  
   | Column         | Type         | Description          |  
   |----------------|--------------|----------------------|  
   | `id`           | INT (PK)     | Unique user ID       |  
   | `phNo`         | VARCHAR(10)  | Phone number         |  
   | `password`     | VARCHAR(50)  | Password             |  

2. **Carts**  
   Stores transaction details for each order.  
   | Column                 | Type          | Description                     |  
   |------------------------|---------------|---------------------------------|  
   | `id`                   | INT (PK)      | Unique cart ID                  |  
   | `NoofchoosedCategories`| INT           | Number of categories selected   |  
   | `Totalprice`           | DECIMAL(10,2) | Total price                     |  

---

## **Sample Outputs**

### **Login Screen**
```
************ LOGIN ***************
Enter PhNumber: 9876543210
Enter Password: ****
Welcome to the Shopping Cart System!
```

### **Billing**
```
Your product will be delivered within 2 business days!
****** THANK YOU VISIT AGAIN ******
```

---

## **Future Enhancements**
1. Add a graphical user interface (GUI).
2. Implement payment gateway integration.
3. Add a product inventory management system.
4. Implement user registration.

---

## **Contributors**
- **Pradeep** (Project Lead and Developer)  

Feel free to contribute to this project by submitting a pull request or raising an issue.

---
