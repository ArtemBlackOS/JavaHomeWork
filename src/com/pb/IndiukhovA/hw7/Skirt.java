package com.pb.IndiukhovA.hw7;

public class Skirt extends Clothes implements WomenClothes{
    private final String name = "Юбка";

    public Skirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressWomen() {
        System.out.println(name + " - Размер " + size + " " + size.getDescription(this.size) + "; Цена " + cost + "грн;" + " Цвет " + color);
    }
}
