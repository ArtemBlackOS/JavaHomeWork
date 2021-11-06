package com.pb.IndiukhovA.hw6;

import java.util.Objects;

public class Cat extends Animal{
    private String catSound;

    public Cat(){
        super("Котейка", "доме", "Китикет");
    }

    public Cat(String catSound){
        super("Котейка","доме", "Китикет");
        this.catSound = catSound;
    }

    @Override
    public void makeNoise() {
        System.out.println("Громко мяукает" + catSound);
    }

    @Override
    public void eat() {
        System.out.println("Ест китикет");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(catSound, cat.catSound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catSound);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catSound='" + catSound + '\'' +
                '}';
    }
}
