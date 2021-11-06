package com.pb.IndiukhovA.hw6;

public class Animal {
    private String food;
    private String location;
    private String name;

    public Animal(String name, String location, String food){
        this.name = name;
        this.food = food;
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeNoise(){
        System.out.println(name + " решило пошуметь");
    }

    public void eat(){
        System.out.println(name + " уже ест");
    }

    public void sleep(){
        System.out.println(name + " спит");
    }

}
