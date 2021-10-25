package com.pb.IndiukhovA.hw4;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

public class Anagram {
    public static String first;
    public static String second;
    public static void main(String[] args) {
        first = scan();
        second = scan();
        res();

    }
    public static String scan(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toLowerCase().replaceAll("[^a-z&&[^а-я]]","");
    }
    public static void res(){
        char[] one = first.toCharArray();
        char[] two = second.toCharArray();
        Arrays.sort(one);
        Arrays.sort(two);
        if(tostr(one).equals(tostr(two))){
            System.out.println("Строка 1 является анаграмой строки 2");
        } else{
            System.out.println("Строки не являются анаграмами");
        }
    }
    public static String tostr(char[] x){
        String v = "";
        for(int y = 0; y < x.length; y++){
            v += x[y];
        }
        return v;
    }
}
