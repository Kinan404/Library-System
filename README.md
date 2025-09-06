# Library Management System  

## Introduction  
A **Library Management System (LMS)** is a software solution designed to simplify and automate the management of library resources, patrons, and their interactions with the library. This project is developed in **Java** with a strong focus on **Object-Oriented Programming (OOP)** concepts.  

The system provides core functionality for managing books, users, and transactions, including:  
- **Book Management**: Adding books, viewing books, tracking available copies.  
- **User Registration**: Registering users with unique credentials.  
- **Transaction Management**: Borrowing and returning books.  
- **Transaction History**: Recording all borrow and return activities.  

The goal of this project is to create a **user-friendly, reliable, and efficient** system that streamlines the daily operations of libraries.  

---

## Objectives  
The primary objectives of this project are:  

1. **Book Management**  
   - Add new books to the library.  
   - Track available and total copies.  
   - Display all books.  

2. **User Registration**  
   - Register users with name and email.  
   - Ensure no duplicate email entries.  

3. **Borrowing & Returning Books**  
   - Allow users to borrow books only if available.  
   - Restrict users from borrowing more than 3 books at once.  
   - Track borrowing history and handle book returns.  

4. **Transaction Recording**  
   - Record each transaction (borrow/return).  
   - Store details such as user, book, type, and date.  

5. **Library Shelves Management**  
   - Organize books into shelves with fixed capacity.  
   - Create new shelves as needed.  

6. **User Interface**  
   - Provide a simple, menu-driven interface for librarians.  
   - Show feedback messages for user actions.  

---

## Goals  
- **Efficient Management**: Automate repetitive manual tasks.  
- **User-Friendly**: Provide an intuitive interface for librarians.  
- **Real-Time Updates**: Track book availability instantly.  
- **Error-Free Transactions**: Use validation checks to prevent mistakes.  
- **Extensibility**: Modular design for easy updates in the future.  

---

## System Design & Architecture  

The project follows a **modular design**, where each component is responsible for specific tasks. The key classes are:  

### 1. **Book Class**  
- Stores book details: title, author, total copies, available copies.  
- Handles book availability checks.  
- Updates availability when books are borrowed or returned.  

### 2. **User Class**  
- Stores user information (name, email, borrowed books).  
- Ensures users cannot borrow more than 3 books.  
- Handles borrowing and returning logic.  

### 3. **Transaction Class**  
- Records borrowing and returning of books.  
- Stores details like user, book, transaction type (borrow/return), and date.  

### 4. **Library Class**  
- Core of the system.  
- Manages books, users, shelves, and transactions.  
- Validates borrowing/returning rules.  
- Keeps a full transaction history.  

### 5. **Main Class**  
- Entry point of the program.  
- Provides a **menu-driven interface** for:  
  - Adding books.  
  - Registering users.  
  - Borrowing/returning books.  
  - Viewing all books.  
  - Viewing transaction history.  

---

## Technologies Used  
- **Java (OOP concepts)** → Core programming language.  
- **Console-based Menu UI** → For user interactions.  

---

## How to Run  
1. Clone this repository:  
   ```bash
   git clone https://github.com/your-username/library-management-system.git
   cd library-management-system
