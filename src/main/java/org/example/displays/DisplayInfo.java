package org.example.displays;

import org.example.IngredientLevelsStorage.IngredientLevelsStorage;

import java.util.Scanner;

public class DisplayInfo {
    Scanner scanner = new Scanner(System.in);
    DisplayPower displayPower = new DisplayPower();
    IngredientLevelsStorage ingredientLevelsStorage = new IngredientLevelsStorage();
    public void displayInfo(){
        System.out.println("""
                Что вы хотите сделать?
                1.Посмотреть содержимое кофе-машины
                2.Приготовить эспрессо
                3.Приготовить капучино
                4.Информационная панель.
                5.Выход""");

        switch(scanner.nextLine()){
            case "1" -> ingredientLevelsStorage.countIngredientsCoffeeMachine();
        }
    }

}