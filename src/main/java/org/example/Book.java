package org.example;

public class Book {
    String name;
    String author;
    Double price;

    public Book(String name, String author, Double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + "," + author + "," + price + "\n";
    }
}
