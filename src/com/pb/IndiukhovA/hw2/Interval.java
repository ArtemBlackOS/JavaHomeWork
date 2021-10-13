package com.pb.IndiukhovA.hw2;
import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;

        System.out.println("Введите произвольное целое число ");
        x = sc.nextInt();

        if(x >= 0 && x <=14){
            System.out.println("Число в промежутке: [0 - 14]");
        } else if(x >= 15 && x <=35){
            System.out.println("Число в промежутке: [15 - 35]");
        }else if(x >= 36 && x <=50){
            System.out.println("Число в промежутке: [36 - 50]");
        }else if(x >= 51 && x <=100){
            System.out.println("Число в промежутке: [51 - 100]");
        } else{
            System.out.println("Указанное вами число не попало ни в один из заданных промежутков");
        }

    }
}
