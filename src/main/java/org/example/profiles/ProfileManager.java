package org.example.profiles;

import org.example.capacityLimits.CapacityLimits;
import org.example.displays.DisplayInfo;
import org.example.exception.NegativeNumberException;
import org.example.exception.NumberValidator;



import java.util.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ProfileManager {
    public static final Map<String, CoffeeProfile> users  = new HashMap<>();

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
        NumberValidator validator = new NumberValidator();
        Scanner sc = new Scanner(System.in);

            System.out.println("Введите ваше имя: ");
            String name = sc.nextLine();

            if (name.matches("[a-zA-Zа-яА-ЯёЁ\\s]+")) {
                System.out.println("Введите сколько кружек капучино: ");
                try {
                    int cappuccino = sc.nextInt();
                    validator.validateNumberDetailed(cappuccino);
                    if(cappuccino > CapacityLimits.MAX_COUNT_CUP){
                        System.err.print("Вы превысили максимальное кол-во кружек!\n");
                        infoProfile();
                    }

                    System.out.println("Введите сколько кружек эспрессо: ");
                    int espresso = sc.nextInt();
                    validator.validateNumberDetailed(espresso);
                    if(espresso > CapacityLimits.MAX_COUNT_CUP){
                        System.err.print("Вы превысили максимальное кол-во кружек!\n");
                        infoProfile();
                    }

                    if((cappuccino + espresso) > CapacityLimits.MAX_COUNT_CUP){
                        System.err.println("ОБЩЕЕ КОЛ-ВО КРУЖЕК НЕ ДОЛЖНО ПРЕВЫШАТЬ ->" + CapacityLimits.MAX_COUNT_CUP);
                        infoProfile();
                    }

                    users.put(name, new CoffeeProfile(cappuccino, espresso));
                    infoProfile();

                } catch (NegativeNumberException e ) {
                    System.err.println("Введите число больше 0");
                    infoProfile();

                }catch (InputMismatchException e){
                    System.err.print("Введите число, а не букву!");
                    infoProfile();
                }
            } else {
                System.out.println("Ошибка: имя должно содержать только буквы!");
                infoProfile();
            }

    }

    public void informationProfile() {
        checkProfileIsEmpty();
            System.out.println("=== ВСЕ ПОЛЬЗОВАТЕЛИ ===");
            for (Map.Entry<String, CoffeeProfile> entry : users.entrySet()) {
                String name = entry.getKey();
                CoffeeProfile profile = entry.getValue();
                System.out.println("Имя: " + name +
                        ", Капучино: " + profile.getCoupCountCappuccino() +
                        ", Эспрессо: " + profile.getCoupCountEspresso());
            }
        infoProfile();
    }

    public void deleteProfile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Что вы хотите удалить?
                1. Конкретного пользователя
                2. Всех пользователей.
                """);
        switch(sc.nextLine()){
            case "1":
                System.out.println("Введите имя пользователя: ");
                checkProfileIsEmpty();
                users.remove(sc.nextLine());
                infoProfile();
            case "2":
                users.clear();
                System.out.println("Все пользователи удалены!");
                infoProfile();
            default:
                infoProfile();
        }
    }

    public void checkProfileIsEmpty(){
        if (users.isEmpty()) {
            System.out.println("=== СПИСОК ПОЛЬЗОВАТЕЛЕЙ ПУСТ ===");
            System.out.println("Нет добавленных пользователей.\n");
            infoProfile();
        }
    }

}