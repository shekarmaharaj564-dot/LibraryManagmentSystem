package com.library.management;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        
        library.addBook(
                new Book(1,
                        "Java Programming",
                        "James Gosling"));

        library.addBook(
                new Book(2,
                        "Python Basics",
                        "Guido Van Rossum"));

        library.addBook(
                new Book(3,
                        "Data Structures",
                        "Mark Allen"));
        library.addBook(
        		new Book(4,
        				"C+ Programming",
        				"Bal GuruSwami"));

        
        library.addUser(
                new User(101,
                        "Shekar"));

        library.addUser(
                new User(102,
                        "Ankit"));

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Display Books");
            System.out.println("2. Display Users");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Available Books");
            System.out.println("6. Search Book");
            System.out.println("7. Display Issued Books");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    library.displayUsers();
                    break;

                case 3:

                    try {

                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();

                        System.out.print("Enter User ID: ");
                        int userId = sc.nextInt();

                        library.issueBook(bookId, userId);

                    } catch (LibraryException e) {

                        System.out.println("Error: "
                                + e.getMessage());
                    }

                    break;

                case 4:

                    try {

                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();

                        library.returnBook(bookId);

                    } catch (LibraryException e) {

                        System.out.println("Error: "
                                + e.getMessage());
                    }

                    break;

                case 5:
                    library.availableBooks();
                    break;

                case 6:

                    sc.nextLine();

                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    library.searchBook(title);

                    break;

                case 7:
                    library.displayIssuedBooks();
                    break;

                case 8:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 8);

        sc.close();
    }
}
