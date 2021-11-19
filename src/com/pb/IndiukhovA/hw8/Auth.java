package com.pb.IndiukhovA.hw8;

public class Auth {
    String login;
    String password;

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        boolean checkLogin = false;
        boolean checkPassword = false;

        if(login.length() >= 5 && login.length() <= 20 && login.matches("^[a-zA-Z0-9]+$")){
                checkLogin = true;
        } else{
            throw new WrongLoginException("Логин введен в неправильном формате, просмотрите инструкцию и повторите ввод");
        }

        if(password.length() > 5 && password.matches("^[a-zA-Z0-9_]+$")){
                checkPassword = true;
        } else{
            throw new WrongPasswordException("Пароль не соответствует требованиям, просмотрите инструкцию и повторите ввод");
        }

        if(checkLogin == true && checkPassword == true && password.equals(confirmPassword)){
            this.login = login;
            this.password = password;
        } else{
            throw new WrongPasswordException("Пароль и подтверждение пароля не равны между собой, повторите попытку");
        }
    }

    public void signIn(String login, String password) throws WrongLoginException{

        if(this.login.equals(login) && this.password.equals(password)){
            System.out.println("Вход подтвержден, добро пожаловать");
        } else {
            throw new WrongLoginException("Неверный логин или пароль, проверьте правильность ввода и повторите попытку");
        }

    }
}
