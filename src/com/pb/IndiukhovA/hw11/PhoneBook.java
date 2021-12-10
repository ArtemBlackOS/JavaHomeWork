package com.pb.IndiukhovA.hw11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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
        for(int i = 0; i < phoneBook.size(); i++){
            if(phoneBook.get(i).getFio().contains(FIO)){
                phoneBook.remove(i);
            }
        }

    }

    public void serchElement(String FIO){
        for(int i = 0; i < phoneBook.size(); i++){
            if(phoneBook.get(i).getFio().contains(FIO)){
                System.out.println("Абонент " + FIO + " есть в нашем справочнике под порядковым номером "
                        + i + " номера телефонов этого абонента: " + phoneBook.get(i).getPhones());
            }
        }
    }

    public void serchElement(String address, LocalDate dateBirthday){
        for(int i = 0; i < phoneBook.size(); i++){
            if(phoneBook.get(i).getAddress().contains(address)){
                System.out.println("По даному адресу живет абонент " + phoneBook.get(i).getFio() + " есть в нашем справочнике под порядковым номером "
                        + i + " номера телефонов этого абонента: " + phoneBook.get(i).getPhones());
            }
        }
    }

    public void sortByName(){
         class byNameComparator implements Comparator<UniqContact>{
             @Override
             public int compare(UniqContact o1, UniqContact o2) {
                 return o1.getFio().compareTo(o2.getFio());
             }
         }
         byNameComparator comparator = new byNameComparator();
         phoneBook.sort(comparator);
        System.out.println(phoneBook);

    }

    public void sortByDateCreate(){
        class byDateCreateNameComparator implements Comparator<UniqContact>{
            @Override
            public int compare(UniqContact o1, UniqContact o2) {
                return o1.getDateCreate().compareTo(o2.getDateCreate());
            }
        }
        byDateCreateNameComparator comparator = new byDateCreateNameComparator();
        phoneBook.sort(comparator);
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
