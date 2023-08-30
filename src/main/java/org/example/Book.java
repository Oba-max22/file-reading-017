package org.example;

public class Book {
    public static int count = 0;

    int id;
    String name;
    String author;
    Double price;

    public Book(String name, String author, Double price) {
        id = count;
        this.name = name;
        this.author = author;
        this.price = price;
        count++;
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

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return id + "," + name + "," + author + "," + price + "\n";
    }
}
