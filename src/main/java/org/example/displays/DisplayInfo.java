package org.example.displays;

import org.example.beverageBrewer.BeverageBrewer;
import org.example.infoPanelCoffeMashine.InformationPanelMachine;
import org.example.ingredientLevelsStorage.IngredientLevelsStorage;
import org.example.profiles.ProfileManager;

import java.util.Scanner;

public class DisplayInfo {

    public void displayInfo(){
        IngredientLevelsStorage ingredientLevelsStorage = new IngredientLevelsStorage();
        Scanner scanner = new Scanner(System.in);
        InformationPanelMachine informationPanelMachine = new InformationPanelMachine();
        BeverageBrewer beverageBrewer = new BeverageBrewer();
        ProfileManager profileManager = new ProfileManager();

        System.out.println("""
                Что вы хотите сделать?
                1.Посмотреть содержимое кофе-машины
                2.Приготовить кофе
                3.Информационная панель.
                4.Профили
                5.Выход""");

        switch(scanner.nextLine()){
            case "1" -> ingredientLevelsStorage.countIngredientsCoffeeMachine();
            case "2" -> beverageBrewer.promptDrinkMenu();
            case "3" -> informationPanelMachine.informationPanel();
            case "4" -> profileManager.infoProfile();
            case "5" -> System.exit(0);
            default -> displayInfo();
        }
    }
}