package org.example.IngredientLevelsStorage;

public class IngredientLevelsStorage {
    public static int amountMilk = 1000 ;
    public static int amountCoffee = 300;
    public static int amountWater = 1000;


    public void countIngredientsCoffeeMachine(){
        System.out.println("Сейчас в кофе машине: "+
                "\nКофе --> " + amountCoffee+
                "\nВоды --> " + amountWater +
                "\nМолока --> " + amountMilk);
    }

    public static void setAmountMilk(int amountMilk) {
        IngredientLevelsStorage.amountMilk = amountMilk;
    }

    public static int getAmountCoffee() {
        return amountCoffee;
    }

    public static void setAmountCoffee(int amountCoffee) {
        IngredientLevelsStorage.amountCoffee = amountCoffee;
    }

    public static int getAmountWater() {
        return amountWater;
    }

    public static void setAmountWater(int amountWater) {
        IngredientLevelsStorage.amountWater = amountWater;
    }
}
