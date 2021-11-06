package com.pb.IndiukhovA.hw6;

import java.util.Objects;
import java.util.SplittableRandom;

public class Dog extends Animal{
    private String colorBooth;
    private String materialBooth;

    public Dog(){
        super("Собака", "будке", "кости");
    }
    public Dog(String colorBooth, String materialBooth){
        super("Собака", "будке", "кости");
        this.colorBooth = colorBooth;
        this.materialBooth = materialBooth;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        if(!colorBooth.isEmpty() && !materialBooth.isEmpty()){
            System.out.println("Началала лаять со своей " + colorBooth + " и " + materialBooth + "будки");
        } else {
            System.out.println("Гав Гав Гав");
        }
    }

    @Override
    public void eat() {
        super.eat();
        if(!colorBooth.isEmpty() && !materialBooth.isEmpty()){
            System.out.println("Ест корм возле своей " + colorBooth + " и " + materialBooth + "будки");
        } else {
            System.out.println("Собачий корм заходит лучше всего");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(colorBooth, dog.colorBooth) && Objects.equals(materialBooth, dog.materialBooth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorBooth, materialBooth);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "colorBooth='" + colorBooth + '\'' +
                ", materialBooth='" + materialBooth + '\'' +
                '}';
    }
}
