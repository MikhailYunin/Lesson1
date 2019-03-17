package com.companyName.lessons;

import java.util.Arrays;

public class Library {
    Book[] books = new Book [4];


    @Override
    public String toString() {
        return "Library{" +
                "books=" + Arrays.toString(books) +
                '}';
    }

    public void addBook (Book book) {
        for (int i = 0; i <this.books.length; i++){
            if (this.books[i] == null){
                this.books[i] = book;
                break;
            }
        }
    }

    public Book[] getBooks(String bookTitle)
    {
        Book result = null;
        for (int i=0; i<this.books.length; i++){
        if (bookTitle.equals(this.books[i].getTitle())) {
            result = books[i];
            break;
        }
    } return books;
    }



}
