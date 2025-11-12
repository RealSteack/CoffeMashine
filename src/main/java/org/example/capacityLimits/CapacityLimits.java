package org.example.capacityLimits;

public class CapacityLimits {
    public final static int MAX_COUNT_WATER = 1000;
    public final static int MAX_COUNT_COFFEE = 500;
    public final static int MAX_COUNT_MILK = 1000;
    public final static byte COFFEE_RECIPE_WATER_BASED = 100;
    public final static byte COFFEE_RECIPE_COFFEE_BASED = 25;
    public final static byte COFFEE_RECIPE_MILK_BASED = 35;
    public final static int MAX_COUNT_CUP = 10;
    private static int countCup;
    private static int cappuccinoCount;
    private static int espressoCount;
    private static int coupCountProfileEspresso;
    private static int coupCountProfileCappuccino;


    public static void setCountCup(int countCup) {
        CapacityLimits.countCup = countCup;
    }

    public static int getCountCup() {
        return countCup;
    }

    public static int getCappuccinoCount() {
        return cappuccinoCount;
    }

    public static int getEspressoCount() {
        return espressoCount;
    }

    public static void setCappuccinoCount(int cappuccinoCount) {
        CapacityLimits.cappuccinoCount = cappuccinoCount;
    }

    public static void setEspressoCount(int espressoCount) {
        CapacityLimits.espressoCount = espressoCount;
    }

    public static int getCoupCountProfileEspresso() {
        return coupCountProfileEspresso;
    }

    public static void setCoupCountProfileEspresso(int coupCountProfileEspresso) {
        CapacityLimits.coupCountProfileEspresso = coupCountProfileEspresso;
    }

    public static int getCoupCountProfileCappuccino() {
        return coupCountProfileCappuccino;
    }

    public static void setCoupCountProfileCappuccino(int coupCountProfileCappuccino) {
        CapacityLimits.coupCountProfileCappuccino = coupCountProfileCappuccino;
    }
}
