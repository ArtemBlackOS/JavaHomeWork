package com.pb.IndiukhovA.hw12;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    List<UniqContact> phoneBook = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void createElement(){
        System.out.println("Для сохнанения данных в телефонную книгу обязательно введжите ФИО абонента:");
        String fio = sc.nextLine();

        ArrayList<String> ph = new ArrayList<>();
        System.out.println("Обязательно введите минимум один номер телефона");
        String answer = "Y";
        while (answer.equals("Y") || answer.equals("Д")){
            System.out.println("Номер необходимо вводить в формате +380...");
            ph.add(sc.nextLine());
            System.out.println("Требуется введение дополнительного номера телефона?");
            System.out.println("ответьте в формате Y или N");
            answer = sc.nextLine();
        }

        System.out.println("Есть возможность ввести дату рождения абонента? Прошу ответить Y/N");
        String dateOfB = sc.nextLine();
        LocalDate dateBirthday = null;
        if (dateOfB.equals("Y") || dateOfB.equals("Д")){
            System.out.println("Введите год рождения:");
            int year = sc.nextInt();
            System.out.println("Введите месяц рождения:");
            int month = sc.nextInt();
            System.out.println("Введите день рождения:");
            int day = sc.nextInt();
            dateBirthday = LocalDate.of(year, month, day);
            sc.nextLine();
        }

        System.out.println("Есть возможность ввести адрес абонента? Прошу ответить Y/N");
        String adr = sc.nextLine();
        String address = "";
        if (adr.equals("Y") || adr.equals("Д")){
            System.out.println("Введите адрес:");
            address = sc.nextLine();
        }

        if(dateOfB.equals("N") && adr.equals("N")){
            phoneBook.add(new UniqContact(fio, ph));
        } else if(dateOfB.equals("Y") && adr.equals("N")){
            phoneBook.add(new UniqContact(fio, dateBirthday, ph));
        } else if(dateOfB.equals("N") && adr.equals("Y")){
            phoneBook.add(new UniqContact(fio, ph, address));
        } else {
            phoneBook.add(new UniqContact(fio, dateBirthday, ph, address));
        }

    }

    public void deleteElement(String FIO){
        phoneBook = phoneBook.stream()
                .filter(x -> !x.getFio().equals(FIO))
                .collect(Collectors.toList());
    }

    public void serchElement(String FIO){
        phoneBook.stream()
                .filter(x -> x.getFio().equals(FIO))
                .forEach((x) -> System.out.println("Абонент " + x.getFio() + " есть в нашем справочнике" + " номера телефонов этого абонента: "  + x.getPhones()));
    }

    public void serchElement(String address, LocalDate dateBirthday){
        phoneBook.stream()
                .filter(x -> x.getAddress().equals(address))
                .forEach((x) -> System.out.println("По даному адресу живет абонент " + x.getFio() + " есть в нашем справочнике и номера телефонов этого абонента: " + x.getPhones()));
    }

    public void sortByName(){
        phoneBook = phoneBook.stream()
                .sorted(Comparator.comparing(UniqContact :: getFio))
                .collect(Collectors.toList());
        System.out.println(phoneBook);
    }

    public void sortByDateCreate(){
        phoneBook = phoneBook.stream()
                .sorted(Comparator.comparing(UniqContact::getDateCreate))
                .collect(Collectors.toList());
        System.out.println(phoneBook);
    }

    public void editElement(String FIO){
        System.out.println("Если Вы хотите изменить ФИО введите \"F\", а если хотите изменить дату рождения, нажмте \"D\"");
        String whatYouWant = sc.nextLine();
        if(whatYouWant.equals("F")){
            System.out.println("Введите новое ФИО: ");
            String fioNew = sc.nextLine();
            for (int i = 0; i < phoneBook.size(); i++){
                if(phoneBook.get(i).getFio().contains(FIO)){
                    phoneBook.get(i).setFio(fioNew);
                    phoneBook.get(i).setDateCreate();
                }
            }
        } else if(whatYouWant.equals("D")){
            System.out.println("Введите год рождения:");
            int year = sc.nextInt();
            System.out.println("Введите месяц рождения:");
            int month = sc.nextInt();
            System.out.println("Введите день рождения:");
            int day = sc.nextInt();
            LocalDate newDateBirthday = LocalDate.of(year, month, day);
            for (int i = 0; i < phoneBook.size(); i++){
                if(phoneBook.get(i).getFio().contains(FIO)){
                    phoneBook.get(i).setDateBirthday(newDateBirthday);
                    phoneBook.get(i).setDateCreate();
                }
            }
        }
    }


    public void writtenData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        objectMapper.registerModule(module);

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(phoneBook);
        objectMapper.writeValue(new File("phoneBook.json"),phoneBook);
        System.out.println(json);
        System.out.println("Запись успешно проведена");
    }

    public ArrayList<UniqContact> loadingData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        objectMapper.registerModule(module);

        File filePhoneBook = new File("phoneBook.json");
        ArrayList<UniqContact> uniqContacts = objectMapper.readValue(filePhoneBook, new TypeReference<ArrayList<UniqContact>>() {});
        System.out.println(uniqContacts);
        System.out.println("Загрузка успешно проведена");
        return uniqContacts;


    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook.toString() +
                '}';
    }
}

