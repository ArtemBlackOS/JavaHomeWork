package com.pb.IndiukhovA.hw10;

import java.util.Arrays;

public class NumBox<T extends Number> {
    private final T[] mass;

    public NumBox(int size){
        mass = (T[]) new Number[size];
    }

    public void add(T num) throws ArrayIndexOutOfBoundsException{
        int i = 0;
        for(T t: mass){
            if(t != null){
                i++;
            }
        }
        mass[i] = num;
    }

    public T get(int index){
        return mass[index];
    }

    public int length(){
        int i = 0;
        for(T t: mass){
            if(t != null){
                i++;
            }
        }
        return i;
    }

    public double average(){
        int i = 0;
        double sum = 0;
        for(T t: mass){
            if(t != null){
                sum = sum + t.doubleValue();
                i++;
            }
        }
        return sum/i;
    }

    public double sum(){
        double sum = 0;
        for(T t: mass){
            if(t != null){
                sum = sum + t.doubleValue();
            }
        }
        return sum;
    }

    public T max(){
        T max1 = mass[0];
        for(T t: mass){
            if(t != null){
                if(max1.doubleValue() < t.doubleValue()){
                    max1 = t;
                }
            }
        }
        return max1;
    }

}
