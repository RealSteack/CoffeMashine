package org.example.displays;

import org.example.IngredientLevelsStorage.IngredientLevelsStorage;

import java.util.Scanner;

public class StartMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DisplayInfo displayInfo = new DisplayInfo();
        DisplayPower displayPower = new DisplayPower();

        displayPower.speakInput();
        switch (sc.nextLine()) {
            case "1" -> displayInfo.displayInfo();
            case "2" -> displayPower.speakOutput();
            default -> System.out.println("Ошибка!");
        }
    }
}
