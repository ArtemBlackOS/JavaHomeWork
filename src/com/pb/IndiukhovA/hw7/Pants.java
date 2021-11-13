package com.pb.IndiukhovA.hw7;

import java.lang.reflect.Member;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    private final String name = "Штани";


    public Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println(name + " - Размер " + size + " " + size.getDescription(this.size) + "; Цена " + cost + "грн;" + " Цвет " + color);
    }

    @Override
    public void dressWomen() {
        System.out.println(name + " - Размер " + size + " " + size.getDescription(this.size) + "; Цена " + cost + "грн;" + " Цвет " + color);
    }
}
