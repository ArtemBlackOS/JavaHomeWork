package com.pb.IndiukhovA.hw4;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        System.out.println("Введите строку которую нужно преобразовать");
        update();

    }
    public static String scan(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static void update(){
        String text = scan();
        StringBuilder result = new StringBuilder();

        String[] arr = text.split(" ");

        for (int i = 0; i < arr.length; i++){
            arr[i] = arr[i].substring(0,1).toUpperCase() + arr[i].substring(1).toLowerCase();
            result.append(arr[i]).append(" ");
        }
        System.out.println(result);
    }
}
