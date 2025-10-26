package org.example.ingridients;

import org.example.quantity.QuantityMachine;

public class Ingridients {
    QuantityMachine quantity = new QuantityMachine();
    public static int MAX_COUNT_WATER = 1000;
    public static int MAX_COUNT_COFFEE = 500;
    public static int MAX_COUNT_MILK = 1000;


    public static int getMaxCountWater() {
        return MAX_COUNT_WATER;
    }

    public static void setMaxCountWater(int maxCountWater) {
        MAX_COUNT_WATER = maxCountWater;
    }

    public static int getMaxCountCoffee() {
        return MAX_COUNT_COFFEE;
    }

    public static void setMaxCountCoffee(int maxCountCoffee) {
        MAX_COUNT_COFFEE = maxCountCoffee;
    }

    public static int getMaxCountMilk() {
        return MAX_COUNT_MILK;
    }

    public static void setMaxCountMilk(int maxCountMilk) {
        MAX_COUNT_MILK = maxCountMilk;
    }
}
