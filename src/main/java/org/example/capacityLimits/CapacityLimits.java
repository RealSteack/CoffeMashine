package org.example.capacityLimits;

public class CapacityLimits {
    public final static int MAX_COUNT_WATER = 1000;
    public final static int MAX_COUNT_COFFEE = 500;
    public final static int MAX_COUNT_MILK = 1000;
    public final static int COFFEE_RECIPE_WATER_BASED = 100;
    public final static int COFFEE_RECIPE_COFFEE_BASED = 25;
    public final static int COFFEE_RECIPE_MILK_BASED = 35;
    public final static int MAX_COUNT_CUP = 10;
    public static int countCup;
    public static int cappuccinoCount;
    public static int espressoCount;

    public static int getCountCup() {
        return countCup;
    }

    public static void setCountCup(int countCup) {
        CapacityLimits.countCup = countCup;
    }
}
