package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SimpleTimeZone;

public class Main {
    public static List<Book> bookList = new ArrayList<>();
    public static List<Book> readList = new ArrayList<>();

    public static final String FILE_LOCATION = "src/main/resources/book.csv";

    public static void main(String[] args) {

        // "Hello world!";
        // 8 bits -> byte
        // Binary - 1010

        // DataSource -> stream (10101000 100000101 10001000) -> Program
        // Program -> stream (10101000 100000101 10001000) -> Data destination
        // how to convert binary into string?
        // how to convert strings in binary?

//        for (int i = 97; i < 123; i++) {
//            char ch = (char) i;
//            System.out.println(ch);
//        }

        // ByteStreams -> Sequence of bytes which are made up of 8-bits (bits -> 1,0)
        // CharacterStreams -> Sequence of characters

        // Java IO - Input and Output

        // Reader Writer
        // FileReader FileWriter
        // BufferedReader BufferedWriter
        // InputStream
        // OutputStream
        // FileInputStream
        // FileOutputStream


//        writeOneCharAtATimeToFile();
//        writeOneLineAtATimeToFile();
//        readOneCharAtATimeToFile();
//        readOneLineAtATimeToFile();

        addBook(new Book("Things Fall Apart", "Chinua Achebe", 4999.99));
        addBook(new Book("Half Of A Yellow Sun", "Chimamanda Adichie", 5999.99));
        addBook(new Book("Purple Hibiscus", "Chimamanda Adichie", 3999.99));

        listBooks();
        System.out.println(removeBook(1));
        listBooks();
    }

    private static void readOneLineAtATimeToFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_LOCATION))){
            String header = br.readLine();
            String line;
            while((line =br.readLine()) != null) {
                String[] row = line.split(",");
                Book book = new Book(row[0], row[1], Double.valueOf(row[2]));
                readList.add(book);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private static void readOneCharAtATimeToFile() {
        try (FileReader fileReader = new FileReader(FILE_LOCATION)){

            String collect = "";
            int c;
            while((c = fileReader.read()) != -1) {
                collect += Character.toString(c);
            }

            String[] strArr = collect.split("\n");
            for (int i = 1; i < strArr.length; i++) {
                String[] row = strArr[i].split(",");
                Book book = new Book(row[0], row[1], Double.valueOf(row[2]));
                readList.add(book);
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private static void writeOneLineAtATimeToFile() {
        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(FILE_LOCATION))){

            String header = "Name" + "," + "Author" + "," + "Price\n";
            bw.write(header);

            for (Book book: bookList) {
                bw.write(book.toString());
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private static void writeOneCharAtATimeToFile() {
        try (FileWriter fileWriter = new FileWriter(FILE_LOCATION)){

            String header = "Name" + "," + "Author" + "," + "Price\n";
            for (int c: header.toCharArray()) {
                fileWriter.write(c);
            }

            for (Book book: bookList) {
                String line = book.toString();
                char[] arr = line.toCharArray();
                int n = line.length()-1;
                while(n >= 0) {
                    fileWriter.write(arr[line.length()-1 - n]);
                    n--;
                }
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void listBooks() {
        // display available books
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_LOCATION))){

            String line;
            while((line =br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static String addBook(Book book) {

        bookList.add(book);
        writeOneLineAtATimeToFile();

        return "Book successfully added!";
    }


    public static String removeBook(int bookId) {

        for (int i = 0; i < bookList.size(); i++) {
            Book currBook = bookList.get(i);
            if (currBook.getId() == bookId) {
                bookList.remove(i);
                break;
            }
        }

        writeOneLineAtATimeToFile();
        return "Book with id :: " + bookId + " successfully removed!";
    }
}