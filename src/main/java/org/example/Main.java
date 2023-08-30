package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Book> bookList = new ArrayList<>();
    public static final String FILE_LOCATION = "src/main/resources/book.csv";

    public static void main(String[] args) {

//        System.out.println(bookList);
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


        Book firstBook = new Book("Things Fall Apart", "Chinua Achebe", 4999.99);
        bookList.add(firstBook);

        Book otherBook = new Book("Half Of A Yellow Sun", "Chimamanda Adichie", 5999.99);
        bookList.add(otherBook);

        // writeOneCharAtATimeToFile();
        writeOneLineAtATimeToFile();
//        readOneCharAtATimeToFile();

    }

//    private static void readOneCharAtATimeToFile() {
//        try (FileReader fileReader = new FileReader(FILE_LOCATION)){
//
//            int c = fileReader.read();
//            while(c != -1) {
//
//                System.out.println(fileReader.read());
//            }
//
//        } catch (IOException io) {
//            io.printStackTrace();
//        }
//    }

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
    }
}