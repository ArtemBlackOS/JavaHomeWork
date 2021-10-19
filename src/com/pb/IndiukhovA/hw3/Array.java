package com.pb.IndiukhovA.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            System.out.println("Введите " + (i+1) + " элемент массива");
            arr[i] = sc.nextInt();
        }

        System.out.println("Вот так выглядит введенный массив: " + Arrays.toString(arr));
        System.out.println("Сумма всех элементов массива составляет: " + Arrays.stream(arr).sum());

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                count++;
            }
        }
        System.out.println("Количество положительных элементов во введенном массиве составляет: " + count);

        boolean sorted = false;
        int buf;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    sorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }

        System.out.println("Отсортированный массив выглядит так: " + Arrays.toString(arr));
    }
}
