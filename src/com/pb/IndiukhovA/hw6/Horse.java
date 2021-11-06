package com.pb.IndiukhovA.hw6;

import java.util.Objects;

public class Horse extends Animal{
    private String saddle;
    private String horseShoe;

    public Horse(){
        super("Конь", "конюшне", "овес");
    }

    public Horse(String saddle, String horseShoe){
        super("Конь", "конюшне", "овес");
        this.saddle = saddle;
        this.horseShoe = horseShoe;
    }

    @Override
    public void makeNoise() {
        System.out.println("Кричит Иго-го-го c " + saddle + " и " + horseShoe);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Овес кажется");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(saddle, horse.saddle) && Objects.equals(horseShoe, horse.horseShoe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saddle, horseShoe);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "saddle='" + saddle + '\'' +
                ", horseShoe='" + horseShoe + '\'' +
                '}';
    }
}
