package com.pb.IndiukhovA.hw8;

import java.sql.SQLOutput;
import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        Auth auth = new Auth();

        System.out.println("Для использования услуги пройдите регистрацию");
        System.out.println("Введите логин пользователя: ");
        String login = sc.nextLine();

        System.out.println("Введите пароль: ");
        String password = sc.nextLine();

        System.out.println("Подтвердите пароль: ");
        String confirmPassword = sc.nextLine();

        try {
            auth.signUp(login, password, confirmPassword);

            System.out.println("Регистрация успешна, для входа в личный кабинет");
            System.out.println("Введите логин: ");
            login = sc.nextLine();

            System.out.println("Введите пароль: ");
            password = sc.nextLine();

            auth.signIn(login, password);
        } catch (WrongLoginException | WrongPasswordException e){
            System.out.println("Внимание! Произошла ошибка");
            e.printStackTrace();
        }
    }
}
