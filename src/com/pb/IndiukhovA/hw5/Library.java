package com.pb.IndiukhovA.hw5;

public class Library {
    public static void main(String[] args) {
        Book [] massBook = {new Book("Приключения", "Иванов И. И.", "2000 г."), new Book("Словарь", "Сидоров А. В", "1980 г."), new Book("Энциклопедия", "Гусев К. В.", "2010 г.")};
        Reader [] massReader = {new Reader("Иванов Иван Иванович", 4343, "Электротехнический", "18.12.2000", "+380967829123"), new Reader("Иванов Петр Васильевич", 4422, "Информатики", "18.11.1988", "+380967473920"), new Reader("Васичкин Василий Сардиньевич", 1111, "Химии", "15.12.1989", "+380678324636")};


        StringBuilder b = new StringBuilder();
        for (int i = 0; i < massBook.length; i++){
            b.append("(").append(massBook[i].nameBook).append(", ").append(massBook[i].authorBook).append(", ").append(massBook[i].yearBook).append("), ");
        }
        System.out.println(b.toString());
        System.out.println();


        StringBuilder r = new StringBuilder();
        for (int i = 0; i < massReader.length; i++){
            r.append("(").append(massReader[i].FIO).append("), ");
        }
        System.out.println(r.toString());
        System.out.println();

        Reader.takeBook(3);

        String [] fff = {"Приключения", "Словарь", "Энциклопедия"};
        Reader.takeBook(fff);

        Reader.takeBook(massBook);

        System.out.println();

        Reader.returnBook(3);
        Reader.returnBook(fff);
        Reader.returnBook(massBook);

    }
}
