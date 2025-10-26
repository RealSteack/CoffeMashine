package org.example.ingredientLevelsStorage;

import org.example.displays.DisplayInfo;

import java.util.Scanner;

public class IngredientLevelsStorage {
    public static int amountMilk = 1000 ;
    public static int amountCoffee = 300;
    public static int amountWater = 1000;

    Scanner sc = new Scanner(System.in);


    public void countIngredientsCoffeeMachine(){
        DisplayInfo displayInfo = new DisplayInfo();
        IngredientDispenser ingredientDispenser = new IngredientDispenser();
        System.out.println("Что вы хотите сделать?" +
                "\n1.Посмотреть содержимое" +
                "\n2.Пополнить содержимое" +
                "\n3.Выйти");
        switch (sc.nextLine()){
            case "1":
                System.out.println("Сейчас в кофе машине: "+
                        "\nКофе --> " + amountCoffee+
                        "\nВоды --> " + amountWater +
                        "\nМолока --> " + amountMilk);
                displayInfo.displayInfo();
            case "2":
                ingredientDispenser.askUserWhatToAdd();
                countIngredientsCoffeeMachine();
            case "3":
                displayInfo.displayInfo();
            default:
                System.out.println("Такой функции не существует, отправляю вас в меню.");
                displayInfo.displayInfo();
        }
    }

    public static int getAmountMilk() {
        return amountMilk;
    }

    public static void setAmountMilk(int amountMilk) {
        IngredientLevelsStorage.amountMilk = amountMilk;
    }

    public static int getAmountWater() {
        return amountWater;
    }

    public static void setAmountWater(int amountWater) {
        IngredientLevelsStorage.amountWater = amountWater;
    }

    public static int getAmountCoffee() {
        return amountCoffee;
    }

    public static void setAmountCoffee(int amountCoffee) {
        IngredientLevelsStorage.amountCoffee = amountCoffee;
    }
}

