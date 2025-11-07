package org.example.ingredientLevelsStorage;


import org.example.capacityLimits.CapacityLimits;

import java.util.Scanner;

import static org.example.capacityLimits.CapacityLimits.*;

public class IngredientDispenser {

    public void promptIngredientSelection(){
        IngredientLevelsStorage ingredientLevelsStorage = new IngredientLevelsStorage();
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Что вы хотите пополнить?
                1.Кофе
                2.Молоко
                3.Воду
                4.Выйти
                """);

        switch(scanner.nextLine()){
            case "1":
                addCoffeeMount();
                promptIngredientSelection();
            case "2":
                addMilkMount();
                promptIngredientSelection();
            case "3":
                addWaterMount();
                promptIngredientSelection();
            case "4":
                ingredientLevelsStorage.countIngredientsCoffeeMachine();
            default:
                promptIngredientSelection();
        }
    }
    public void addCoffeeMount() {
        Scanner sc = new Scanner(System.in);
        IngredientLevelsStorage storage = new IngredientLevelsStorage();

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
    public void addMilkMount(){
        Scanner sc = new Scanner(System.in);
        IngredientLevelsStorage storage = new IngredientLevelsStorage();

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
    public void addWaterMount(){
        Scanner sc = new Scanner(System.in);
        IngredientLevelsStorage storage = new IngredientLevelsStorage();

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
    public void cleanUpCountCup(){
        Scanner sc = new Scanner(System.in);
        IngredientLevelsStorage storage = new IngredientLevelsStorage();
        if(CapacityLimits.getCountCup() == 0){
            System.out.println("Машина не нуждается в чистке!");
            storage.countIngredientsCoffeeMachine();
        }
        System.out.println("""
                Вы хотите включить кофе-машину?
                1.Да
                2.Нет
                """);
        switch(sc.nextLine()){
            case "1":
                CapacityLimits.setCountCup(0);
                System.out.println("Кофе-машина очищена!");
                storage.countIngredientsCoffeeMachine();
            case "2":
                storage.countIngredientsCoffeeMachine();
        }
    }
}
