package org.example.profiles;

import org.example.capacityLimits.CapacityLimits;
import org.example.displays.DisplayInfo;


import java.util.*;
import java.util.Scanner;

public class ProfileManager {
    static private final Map<String, CoffeeProfile> users  = new TreeMap<>();

    public void infoProfile(){
        DisplayInfo displayInfo = new DisplayInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ===Добро пожаловать в систему пользователей!===
                1.Добавить пользователя
                2.Посмотреть пользователей
                3.Удалить пользователя
                4.Выйти
                """);
        switch(sc.next()){
            case "1"-> addProfile();
            case "2"-> informationProfile();
            case "3" -> deleteProfile();
            case "4"-> displayInfo.displayInfo();
            default -> infoProfile();
        }
    }

    public void addProfile() {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Введите ваше имя: ");
            String name = sc.nextLine();
            // Проверку спиздил у GPT, потому не ебу как тут проверить ввёл пользователь блять число или символ
            // Но суть не много понял
            if (name.matches("[a-zA-Zа-яА-ЯёЁ\\s]+")) {
                System.out.println("Введите сколько кружек капучино: ");
                int cappuccino = sc.nextInt();

                if(cappuccino < 0 || cappuccino > CapacityLimits.MAX_COUNT_CUP){
                    System.err.print("Должно быть больше 0 и не превышать максимальное кол-во кружек\n");
                    infoProfile();
                }

                System.out.println("Введите сколько кружек эспрессо: ");
                int espresso = sc.nextInt();

                if(espresso < 0 || espresso > CapacityLimits.MAX_COUNT_CUP){
                    System.err.print("Должно быть больше 0 и не превышать максимальное кол-во кружек \n");
                    infoProfile();
                }

                users.put(name, new CoffeeProfile(cappuccino, espresso));
                infoProfile();

            } else {
                System.out.println("Ошибка: имя должно содержать только буквы!");
                infoProfile();
            }


        } catch (Exception e) {
            infoProfile();
            throw new RuntimeException(e);
        }
    }


    public void informationProfile() {
        if (users.isEmpty()) {
            System.out.println("=== СПИСОК ПОЛЬЗОВАТЕЛЕЙ ПУСТ ===");
            System.out.println("Нет добавленных пользователей.\n");
        } else {
            System.out.println("=== ВСЕ ПОЛЬЗОВАТЕЛИ ===");
            for (Map.Entry<String, CoffeeProfile> entry : users.entrySet()) {
                String name = entry.getKey();
                CoffeeProfile profile = entry.getValue();
                System.out.println("Имя: " + name +
                        ", Капучино: " + profile.getCoupCountCappuccino() +
                        ", Эспрессо: " + profile.getCoupCountEspresso());
            }
        }
        infoProfile();
    }
    public void deleteProfile() {
        Scanner sc = new Scanner(System.in);
        if (users.isEmpty()) {
            System.out.println("Список пуст!");
            infoProfile();
        }else{
            System.out.println("Введите пользователя который хотите удалить: ");
            users.remove(sc.nextLine());
            infoProfile();
        }
    }
}
