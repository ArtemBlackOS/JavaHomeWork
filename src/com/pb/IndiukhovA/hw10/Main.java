package com.pb.IndiukhovA.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox<Float> n = new NumBox<>(8);
        NumBox<Integer> m = new NumBox<>(20);
        try {
            System.out.println("Добавляем число в массив");

            n.add(455.0F);
            n.add(5.0F);
            n.add(44.70F);
            n.add(1356.0F);
            n.add(1.1F);
            n.add(32.7F);
            n.add(4.0F);

            m.add(4);
            m.add(55);
            m.add(3);
            m.add(444);
            m.add(5645);
            m.add(3);

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Массив полный измените размерность массива если нужно записать больше значений");
            e.printStackTrace();
        }

        System.out.println("Возвращаем число по индексу");
        System.out.println(n.get(2));
        System.out.println(m.get(2));

        System.out.println("Возвращаем текущее число элементов");
        System.out.println(n.length());
        System.out.println(m.length());

        System.out.println("Возвращаем среднее арифметическое среди элементов массива.");
        System.out.println(n.average());
        System.out.println(m.average());

        System.out.println("Возвращаем сумму всех элементов массива");
        System.out.println(n.sum());
        System.out.println(m.sum());

        System.out.println("максимальный элемент массива");
        System.out.println(n.max());
        System.out.println(m.max());
    }
}
