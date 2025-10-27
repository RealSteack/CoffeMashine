package org.example.ingredientLevelsStorage;


import org.example.displays.DisplayInfo;

import java.util.Scanner;

import static org.example.capacityLimits.CapacityLimits.*;

public class IngredientDispenser {
    Scanner sc = new Scanner(System.in);
    IngredientLevelsStorage storage = new IngredientLevelsStorage();

    void addCoffeeMount() {
        System.out.println("Введите кол-во кофе:");
        int coffeeMountNum = sc.nextInt();
        if(coffeeMountNum < 0 ) {
            System.out.println("ВЫ НЕ МОЖЕТЕ ПРИНЯТЬ ОТРИЦАТЕЛЬНОЕ ЧИСЛО!");
            storage.countIngredientsCoffeeMachine();
        }
        if ((IngredientLevelsStorage.getAmountCoffee() + coffeeMountNum) <= MAX_COUNT_COFFEE ) {
            IngredientLevelsStorage.setAmountCoffee(IngredientLevelsStorage.getAmountCoffee() + coffeeMountNum);
        }else{
            System.out.println("Вы превысили лимит!");
            IngredientLevelsStorage.amountCoffee = MAX_COUNT_COFFEE;
        }
    }

    void addMilkMount(){
        System.out.println("Введите кол-во молока:");
        int milkMountNum = sc.nextInt();
        if(milkMountNum < 0 ) {
            System.out.println("ВЫ НЕ МОЖЕТЕ ПРИНЯТЬ ОТРИЦАТЕЛЬНОЕ ЧИСЛО!");
            storage.countIngredientsCoffeeMachine();
        }
        if((IngredientLevelsStorage.getAmountMilk() + milkMountNum) <= MAX_COUNT_MILK){
            IngredientLevelsStorage.setAmountMilk(IngredientLevelsStorage.getAmountMilk() + milkMountNum);
        }else{
            System.out.println("Вы превысили лимит!");
            IngredientLevelsStorage.amountMilk = MAX_COUNT_MILK;
        }
    }

    void addWaterMount(){
        System.out.println("Введите кол-во воды:");
        int waterMountNum = sc.nextInt();
        if(waterMountNum < 0 ) {
            System.out.println("ВЫ НЕ МОЖЕТЕ ПРИНЯТЬ ОТРИЦАТЕЛЬНОЕ ЧИСЛО!");
            storage.countIngredientsCoffeeMachine();
        }
        if((IngredientLevelsStorage.getAmountWater() + waterMountNum) <= MAX_COUNT_WATER){
            IngredientLevelsStorage.setAmountWater(IngredientLevelsStorage.getAmountWater() + waterMountNum);
        }else{
            System.out.println("Вы превысили лимит!");
            IngredientLevelsStorage.amountWater = MAX_COUNT_WATER;
        }
    }
}
