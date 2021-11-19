package com.pb.IndiukhovA.hw8;

public class WrongPasswordException extends Exception{

    public WrongPasswordException() {
    }

    public WrongPasswordException(String mes) {
        super(mes);
    }
}
