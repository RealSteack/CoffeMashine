package org.example.infoPanelCoffeMashine;

import org.example.displays.DisplayInfo;
import org.example.ingredientLevelsStorage.IngredientLevelsStorage;

import java.util.Scanner;

public class informationPanelMachine {

    public void informationPanel() {
        Scanner sc = new Scanner(System.in);
        DisplayInfo displayInfo = new DisplayInfo();


        System.out.println("""
                Информационная панель
                Что вы хотите посмотреть?
                1.Сколько сейчас ингридиентов в кофе-машине
                2.Рецепты которая сейчас есть в кофе-машине
                3.Нужно ли очистить кофе-машину
                4.Выйти в меню
                """);

        switch (sc.nextLine()){
            case "1":
                System.out.println("Сейчас в кофе машине: "+
                        "\nКофе --> " + IngredientLevelsStorage.getAmountCoffee()+
                        "\nВоды --> " + IngredientLevelsStorage.getAmountWater() +
                        "\nМолока --> " + IngredientLevelsStorage.getAmountMilk());
                informationPanel();
            case "2":
                System.out.println();
//            case "3"
            default:
                displayInfo.displayInfo();
        }
    }
}
