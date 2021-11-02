package com.pb.IndiukhovA.hw5;
import java.io.CharArrayReader;
import java.util.*;

public class Reader {
    String FIO;
    int numberBilet;
    String fakultet;
    String dateBirth;
    String phone;

    public Reader(String FIO, int numberBilet, String fakultet, String dateBirth, String phone){
        this.FIO = FIO;
        this.numberBilet = numberBilet;
        this.fakultet = fakultet;
        this.dateBirth = dateBirth;
        this.phone = phone;
    }

    public static void takeBook(int col){
        System.out.println("Петров В. В. взял " +  col + " книги");
    }

    public static void takeBook(String[] listOfBook){
        String myList = "";
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < listOfBook.length; i++){
            st.append(listOfBook[i]).append(", ");
        }
        myList = st.toString();
        System.out.println("Петров В. В. взял книги: " + myList);
    }

    public static void takeBook(Book [] bookList){
        String myList = "";
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < bookList.length; i++){
            st.append(bookList[i].nameBook).append(" (").append(bookList[i].authorBook).append(" ").append(bookList[i].yearBook);
            if(i == bookList.length-1){
                st.append(").");
            } else {
                st.append("), ");
            }
                {
            }
        }
        myList = st.toString();
        System.out.println("Петров В. В. взял книги: " + myList);
    }

    public static void returnBook(int col){
        System.out.println("Петров В. В. вернул " +  col + " книги");
    }

    public static void returnBook(String[] listOfBook){
        String myList = "";
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < listOfBook.length; i++){
            st.append(listOfBook[i]).append(", ");
        }
        myList = st.toString();
        System.out.println("Петров В. В. вернул книги: " + myList);
    }

    public static void returnBook(Book [] bookList){
        String myList = "";
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < bookList.length; i++){
            st.append(bookList[i].nameBook).append(" (").append(bookList[i].authorBook).append(" ").append(bookList[i].yearBook);
            if(i == bookList.length-1){
                st.append(").");
            } else {
                st.append("), ");
            }
            {
            }
        }
        myList = st.toString();
        System.out.println("Петров В. В. вернул книги: " + myList);
    }

}
