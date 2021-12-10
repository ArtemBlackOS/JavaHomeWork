package com.pb.IndiukhovA.hw11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        PhoneBook p = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Уточните какое действие в справочнике вы хотите совершить:");
            System.out.println("для добавления элемента напишите \"добавить или add\" \n" +
                    "для удаления элемента напишите \"удалить или delete\" \n" +
                    "для поиска элементов по ФИО напишите \"поиск ФИО или search fio\" \n" +
                    "для поиска элементов по адресу напишите \"поиск адрес или search address\" \n" +
                    "для редактирования элемента напишите \"редакт или edit\"\n" +
                    "для вывода всех записей с сортировкой по ФИО напишите \"сорт фио или sort fio\" \n" +
                    "для вывода всех записей с сортировкой по дате изменения напишите \"сорт дата или sort data\" \n" +
                    "для записи в файл всех данных напишите \"запись или write\" \n" +
                    "для загрузки из файла всех данных напишите \"загрузка или load\" \n" +
                    "для завершения программы нажмите \"конец или end\" ");
            boolean a = true;
            int count = 0;
            String answer = "Y";

            while (a){
                if(count > 0) {
                    System.out.println("Продолжаем работу со справочником? Y/N");
                    answer = sc.nextLine();
                }

                if (answer.equals("Y")) {
                    String rez = sc.nextLine();
                    switch (rez) {
                        case "добавить":
                        case "add":
                            p.createElement();
                            break;
                        case "удалить":
                        case "delete":
                            System.out.println("Введите ФИО контакта которого нужно удалить: ");
                            p.deleteElement(sc.nextLine());
                            break;
                        case "поиск ФИО":
                        case "search fio":
                            System.out.println("Введите ФИО контакта который нужно найти: ");
                            p.serchElement(sc.nextLine());
                            break;
                        case "поиск адрес":
                        case "search address":
                            System.out.println("Введите адресс контакта который нужно найти: ");
                            p.serchElement(sc.nextLine(), null);
                            break;
                        case "редакт":
                        case "edit":
                            System.out.println("Введите ФИО контакта которого нужно отредактировать: ");
                            p.editElement(sc.nextLine());
                            break;
                        case "сорт фио":
                        case "sort fio":
                            p.sortByName();
                            break;
                        case "сорт дата":
                        case "sort data":
                            p.sortByDateCreate();
                            break;
                        case "запись":
                        case "write":
                            p.writtenData();
                            break;
                        case "загрузка":
                        case "load":
                            p.loadingData();
                            break;
                        case "конец":
                        case "end":
                            a = false;
                            break;
                        default:
                            System.out.println("Вы ввели что-то не так, посмотрите инструкцию и повторите попытку");
                            a = false;
                            break;
                    }
                    count++;
                } else if(answer.equals("N")){
                    System.out.println("Работа завершена, до скорых встречь");
                    a = false;
                } else {
                    System.out.println("Работа завершена так как ваш ответ был не согласно стандарта");
                    a = false;
                }
            }
        } catch (Exception e){
            System.out.println("Есть ошибка, проверь правильность ввода");
            e.printStackTrace();
        }
    }

}
