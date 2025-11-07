package org.example.infoPanelCoffeMashine;

import org.example.capacityLimits.CapacityLimits;
import org.example.coffeeRecipeType.CoffeeRecipeType;
import org.example.displays.DisplayInfo;

import java.util.Scanner;

public class InformationPanelMachine {

    public void informationPanel() {
        Scanner sc = new Scanner(System.in);
        DisplayInfo displayInfo = new DisplayInfo();

        System.out.println("""
                Информационная панель
                Что вы хотите посмотреть?
                1.Рецепты которая сейчас есть в кофе-машине
                2.Сколько кружек в кофе-машине
                3.Добавить профиль
                4.Посмотреть кол-во и типов кофе которые мы сделали
                5.Выйти в меню
                """);

        switch (sc.nextLine()){
            case "1":
                System.out.println(CoffeeRecipeType.ESPRESSO.getRecipe());
                System.out.printf(CoffeeRecipeType.CAPPUCCINO.getRecipe());
                informationPanel();
            case "2":
                System.out.println("На данный момент в кофе-машине : " + CapacityLimits.getCountCup());
                informationPanel();
//            case "3":
//                System.out.println("Функция в разработке!");
            case "4":
                System.out.println("====КОЛИЧЕСТВО КРУЖЕК КОТОРЫЕ БЫЛИ СДЕЛАНЫ====" +
                        "\nСделано Капучино --> " + CapacityLimits.getCappuccinoCount() +
                        "\nСделано Эспрессо --> " + CapacityLimits.getEspressoCount());
                informationPanel();
            case "5":
                displayInfo.displayInfo();
            default:
                informationPanel();
        }
    }
}
