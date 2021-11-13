package com.pb.IndiukhovA.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{
    private final String name = "Футболка";

    public Tshirt(Size size, double cost, String color) {
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
