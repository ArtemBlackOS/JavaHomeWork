package com.pb.IndiukhovA.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {
    public static void main(String[] args) throws Exception{

        Animal [] anim = new Animal[] {new Cat(), new Dog(), new Horse(), new Cat("Мяу"), new Dog("Красный", "Железная"), new Horse("кожанным седлом","Золотыми подковами")};
        Veterinarian vt = new Veterinarian();

        for(Animal a: anim){
            Class clazz = Class.forName("com.pb.IndiukhovA.hw6.Veterinarian");
            Constructor nn = clazz.getConstructor(new Class[] {});
            Object obj = nn.newInstance();
            if (obj instanceof Veterinarian) {
                ((Veterinarian) obj).treatAnimal(a);
            }
        }

    }
}
