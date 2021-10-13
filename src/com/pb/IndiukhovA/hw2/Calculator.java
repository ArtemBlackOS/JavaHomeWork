package com.pb.IndiukhovA.hw2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operand1;
        int operand2;
        String sigh;

        System.out.println("Введите первое целое число: ");
        operand1 = sc.nextInt();

        System.out.println("Введите второе целое число: ");
        operand2 = sc.nextInt();

        System.out.println("Введите знак арифметической операции: ");
        sigh = sc.next();

        switch (sigh){
            case "+" :
                System.out.println("Ваш результат = " + (operand1 + operand2));
                break;
            case "-" :
                System.out.println("Ваш результат = " + (operand1 - operand2));
                break;
            case "*" :
                System.out.println("Ваш результат = " + (operand1 * operand2));
                break;
            case "/" :
                if(operand2 == 0){
                   System.out.println("Ошибка: Деление на 0 невозможно, повторите попытку");
                    break;
                }
                System.out.println("Ваш результат = " +  ((double)operand1 / operand2));
                break;
            default:
                System.out.println("Я пока не могу работать с этой операцией");

        }

    }



}
