package com.pb.IndiukhovA.hw12;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UniqContact {
    private String fio;
    private LocalDate dateBirthday;
    private ArrayList<String> phones;
    private String address;
    private String dateCreate;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
        setDateCreate();
    }

    public LocalDate getDateBirthday() {
        if(this.dateBirthday != null){
            return dateBirthday;
        } else {
            return null;
        }
    }

    public void setDateBirthday(LocalDate dateBirthday) {
        this.dateBirthday = dateBirthday;
        setDateCreate();
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
        setDateCreate();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        setDateCreate();
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate() {
        this.dateCreate = new SimpleDateFormat("yyyy.MM.dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    }

    public UniqContact(){
        setDateCreate();
    }

    public UniqContact(String fio, ArrayList<String> phones) {
        this.fio = fio;
        this.phones = phones;
        setDateCreate();
    }

    public UniqContact(String fio, LocalDate dateBirthday, ArrayList<String> phones, String address) {
        this.fio = fio;
        this.dateBirthday = dateBirthday;
        this.phones = phones;
        this.address = address;
        setDateCreate();
    }

    public UniqContact(String fio, LocalDate dateBirthday, ArrayList<String> phones) {
        this.fio = fio;
        this.dateBirthday = dateBirthday;
        this.phones = phones;
        setDateCreate();
    }

    public UniqContact(String fio, ArrayList<String> phones, String address) {
        this.phones = phones;
        this.address = address;
        setDateCreate();
    }

    @Override
    public String toString() {
        return "UniqContact{" +
                "fio='" + fio + '\'' +
                ", dateBirthday=" + dateBirthday +
                ", phones=" + phones +
                ", address='" + address + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                '}';
    }
}
