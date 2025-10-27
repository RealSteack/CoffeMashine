package org.example.displays;

import org.example.infoPanelCoffeMashine.informationPanelMachine;
import org.example.ingredientLevelsStorage.IngredientLevelsStorage;

import java.util.Scanner;

public class DisplayInfo {
    IngredientLevelsStorage ingredientLevelsStorage = new IngredientLevelsStorage();
    Scanner scanner = new Scanner(System.in);
    informationPanelMachine informationPanelMachine = new informationPanelMachine();

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
            case "2" -> displayInfo();
            case "3" -> displayInfo();
            case "4" -> informationPanelMachine.informationPanel();
        }
    }

}