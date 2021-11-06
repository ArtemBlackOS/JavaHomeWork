package com.pb.IndiukhovA.hw6;

public class Veterinarian {

    public void treatAnimal(Animal animal){
        System.out.println("этот " + animal.getName() + " ест " + animal.getFood());
        System.out.println("этот " + animal.getName() + " находится " + animal.getLocation());
        System.out.println();
    }
}
