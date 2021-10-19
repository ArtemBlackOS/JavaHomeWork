package com.pb.IndiukhovA.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    private static int mystery;
    public static void main(String[] args) {
        mystery = ran();
        System.out.println("Я загадал число в диапазоне от 0 до 100, отгадаешь? ");
        System.out.println("*-для остановки программы введи число со знаком минус");
        result();
    }

    public static int ran(){
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public static int scan(){
        Scanner sc = new Scanner(System.in);
        return (sc.nextInt());
    }

    public static String moreOrLess(int x, int y){
        if(x > y){
            return "больше";
        } else if(x < y){
            return "меньше";
        } else{
            return "равно";
        }
    }

    public static void result(){
        boolean x = true;
        int y = 0;

        while(x){
            int answer = scan();
            y++;
            if(answer < 0){
                System.out.println("Игра остановлена пользователем");
                break;
            }
            if (mystery == answer) {
                String r;

                if(y < 6){
                     r = "ты крут!";
                }else if(y >= 6 && y <= 12){
                     r = "хороший результат!";
                } else{
                     r = "тебе ещё нужно тренероваться!";
                }

                System.out.println("Ответ правильный!!! Ты отгадал число за " + y + " раз, " + r);
                x = false;
            } else{
                System.out.println("Ты не угадал, задуманное число " + " " + moreOrLess(mystery, answer) + " введенного");
            }
        }
    }
}
