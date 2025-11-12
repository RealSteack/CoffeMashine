package org.example.ingredientLevelsStorage;

import org.example.displays.DisplayInfo;

import java.util.Scanner;

public class IngredientLevelsStorage {

    public static int amountMilk;

    public static int amountCoffee;

    public static int amountWater;

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

    public void countIngredientsCoffeeMachine(){
        Scanner sc = new Scanner(System.in);
        DisplayInfo displayInfo = new DisplayInfo();
        IngredientDispenser ingredientDispenser = new IngredientDispenser();
        System.out.println("""
                Что вы хотите сделать?
                1.Посмотреть содержимое
                2.Пополнить кофе-автомат
                3.Очистить кофе машину
                4.Выйти""");
        switch (sc.nextLine()){
            case "1":
                System.out.println("Сейчас в кофе-машине:" +
                        "\nВода --> " + getAmountWater() +
                        "\nМолоко --> " + getAmountMilk()+
                        "\nКофе --> " + getAmountCoffee());
                countIngredientsCoffeeMachine();
            case "2":
                ingredientDispenser.promptIngredientSelection();
            case "3":
                ingredientDispenser.cleanUpCountCup();
            case "4":
                displayInfo.displayInfo();
            default:
                countIngredientsCoffeeMachine();
        }
    }

}

