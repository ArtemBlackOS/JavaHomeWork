package com.pb.IndiukhovA.hw7;

public class Tie extends Clothes implements ManClothes{
    private final String name = "Галстук";

    public Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println(name + " - Размер " + size + " " + size.getDescription(this.size) + "; Цена " + cost + "грн;" + " Цвет " + color);
    }
}
