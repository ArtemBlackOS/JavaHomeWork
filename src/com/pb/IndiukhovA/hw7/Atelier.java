package com.pb.IndiukhovA.hw7;

public class Atelier {
    private static Size ss;

    public static void main(String[] args) {
        Pants p1 = new Pants(Size.M, 333.3, "Black");
        Pants p2 = new Pants(Size.XXS, 700, "Blue");
        Skirt s1 = new Skirt(Size.XS, 400.0,"Red");
        Skirt s2 = new Skirt(Size.S, 600.0,"Grey");
        Tie t = new Tie(Size.L,250.0, "Black");
        Tshirt ts = new Tshirt(Size.M, 1100, "White");

        Clothes[] cl = {p1, p2, s1, s2, t, ts};

        dressMan(cl);
        dressWomen(cl);
    }

    public static void dressMan(Clothes[] clothes){
        System.out.println("Мужская одежда это:");
        for (Clothes cl: clothes){
            if(cl instanceof ManClothes){
                ((ManClothes) cl).dressMan();
            }
        }
        System.out.println();
    }

    public static void dressWomen(Clothes[] clothes){
        System.out.println("Женская одежда это:");
        for(Clothes cl: clothes){
            if(cl instanceof WomenClothes){
                ((WomenClothes) cl).dressWomen();
            }
        }
        System.out.println();
    }
}
