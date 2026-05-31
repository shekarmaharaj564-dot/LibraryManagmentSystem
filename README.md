# Library Management System

## Overview

This project is a simple Library Management System developed in Java using Object-Oriented Programming (OOP) principles.

The application allows:

- Adding books
- Adding users
- Issuing books to users
- Returning books
- Searching books
- Viewing available books
- Viewing issued books

The project demonstrates the use of:

- OOP Concepts
- ArrayList
- HashMap
- Exception Handling
- Java 8 Lambda Expressions
- Java 8 Streams API

---

## Technologies Used

- Java 8+
- Collections Framework
  - ArrayList
  - HashMap
- Streams API
- Lambda Expressions

---

## Project Structure

src/
├── Book.java
├── User.java
├── Library.java
├── LibraryException.java
└── Main.java

---

## Features

### Book Management
- Store book details
- Display all books
- Search books by title

### User Management
- Store user details
- Display all users

### Issue and Return Books
- Issue books to registered users
- Return issued books
- Track which user borrowed which book

### Exception Handling
- Book not found
- User not found
- Book already issued
- Book not issued

---

## How to Run

### Compile

```bash
javac *.java
