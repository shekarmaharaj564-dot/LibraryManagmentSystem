package com.library.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    private HashMap<Integer, User> users = new HashMap<>();

    
    private HashMap<Integer, Integer> issuedBooks = new HashMap<>();

    
    public void addBook(Book book) {
        books.add(book);
    }

    
    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    
    public void displayBooks() {

        System.out.println("\n----- BOOKS -----");
        
      

        books.forEach(System.out::println);
    }

    
    public void displayUsers() {

        System.out.println("\n----- USERS -----");

        users.values().forEach(System.out::println);
    }

  
    private Book findBook(int bookId)
            throws LibraryException {

        return books.stream()
                .filter(book -> book.getId() == bookId)
                .findFirst()
                .orElseThrow(() ->
                        new LibraryException("Book not found."));
    }
    public void issueBook(int bookId, int userId)
            throws LibraryException {

        findBook(bookId);

        if (!users.containsKey(userId)) {
            throw new LibraryException("User not found.");
        }

        if (issuedBooks.containsKey(bookId)) {
            throw new LibraryException("Book already issued.");
        }

        issuedBooks.put(bookId, userId);

        System.out.println("Book issued successfully.");
    }

    public void returnBook(int bookId)
            throws LibraryException {

        if (!issuedBooks.containsKey(bookId)) {
            throw new LibraryException("Book is not issued.");
        }

        issuedBooks.remove(bookId);

        System.out.println("Book returned successfully.");
    }

    
    public void availableBooks() {

        System.out.println("\n----- AVAILABLE BOOKS -----");

        List<Book> available = books.stream()
                .filter(book ->
                        !issuedBooks.containsKey(book.getId()))
                .collect(Collectors.toList());

        available.forEach(System.out::println);
    }

    // Search
    public void searchBook(String title) {

        System.out.println("\n----- SEARCH RESULT -----");

        List<Book> result = books.stream()
                .filter(book ->
                        book.getTitle()
                                .toLowerCase()
                                .contains(title.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No book found.");
        } else {
            result.forEach(System.out::println);
        }
    }

    
    public void displayIssuedBooks() {

        System.out.println("\n----- ISSUED BOOKS -----");

        if (issuedBooks.isEmpty()) {
            System.out.println("No books issued.");
            return;
        }

        issuedBooks.forEach((bookId, userId) -> {

            try {

                Book book = findBook(bookId);
                User user = users.get(userId);

                System.out.println(
                        book.getTitle() +
                        " --> Issued to --> " +
                        user.getName()
                );

            } catch (LibraryException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
