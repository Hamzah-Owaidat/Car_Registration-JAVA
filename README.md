# Car Registration Application

## Overview
The Car Registration Application is a Java Swing-based GUI application that allows users to perform CRUD (Create, Read, Update, Delete) operations on a car registration database. The application connects to a MySQL database to store and retrieve car information, including the car registration number, model, owner's name, year, registration status, and whether it's a new car.

## Features
- **Add Car**: Allows users to add a new car entry to the database.
- **Update Car**: Enables users to update the details of an existing car entry.
- **Remove Car**: Allows users to remove a car entry from the database.
- **Find Car**: Fetches and displays the details of a car based on the registration number.
- **Clear**: Clears the form inputs.

## Technologies Used
- **Java**: Core language used for the application.
- **Swing**: Used for building the GUI.
- **JDBC**: Java Database Connectivity for database operations.
- **MySQL**: Database to store car registration details.

## Prerequisites
- **Java JDK**: Ensure you have JDK installed. [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **MySQL Database**: Ensure you have MySQL installed. [Download MySQL](https://dev.mysql.com/downloads/installer/)
- **JDBC Driver**: MySQL JDBC driver should be added to your project's classpath. [Download JDBC Driver](https://dev.mysql.com/downloads/connector/j/)

## Database Setup
1. Install MySQL and start the MySQL server.
2. Create a database named `carregistration`:
   ```sql
   CREATE DATABASE carregistration;
3. Create a table named `cars`:
   ```sql
   CREATE TABLE cars (
  id VARCHAR(50) PRIMARY KEY,
  name VARCHAR(100),
  year VARCHAR(4),
  model VARCHAR(100),
  registered CHAR(1),
  newCar INT
);

   
