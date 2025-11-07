package org.example.beverageBrewer;

import org.example.capacityLimits.CapacityLimits;
import org.example.displays.DisplayInfo;
import org.example.ingredientLevelsStorage.IngredientLevelsStorage;

import java.util.Scanner;

import static org.example.capacityLimits.CapacityLimits.*;

public class BeverageBrewer {

    public void promptDrinkMenu(){
        DisplayInfo displayInfo = new DisplayInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ====ВЫБЕРИТЕ КОФЕ====
                1.Эспрессо
                2.Капучино
                3.Приготовить 3 Капучино
                4.Приготовить 3 Эспрессо
                5.Приготовить кофе по профилю
                6.Выйти""");
        switch(sc.nextLine()){
            case "1" -> espressoPreparation();
            case "2" -> cappuccinoPreparation();
            case "3" -> prepareThreeDrinksCappuccino();
            case "4" -> prepareThreeDrinksEspresso();
            case "5" -> prepareForProfile();
            case "6" -> displayInfo.displayInfo();
            default -> promptDrinkMenu();
        }
    }
    // Отдельная проверка для приготовления Эспрессо
    public void validateIngredientLevelsStorageEspresso(){
        if(IngredientLevelsStorage.getAmountWater() <= CapacityLimits.COFFEE_RECIPE_WATER_BASED){
            System.out.println("Не хватает воды!");
            promptDrinkMenu();
        }
        if(IngredientLevelsStorage.getAmountCoffee() <= CapacityLimits.COFFEE_RECIPE_COFFEE_BASED){
            System.out.println("Вам не хватает кофе!");
            promptDrinkMenu();
        }
    }
    // Проверка на превышение максимальное кол-во кружек в кофе-машине
    public void validateCupCount(int inputCountCup ){
        if((CapacityLimits.getCountCup() + inputCountCup) >= MAX_COUNT_CUP){
            System.out.println("Необходимо очистить кофе-машину!");
            CapacityLimits.setCountCup(MAX_COUNT_CUP);
            promptDrinkMenu();
        }
    }
    // Отдельная проверка для приготовления Капучино
    public void validateIngredientLevelsStorageCappuccino(){
        if(IngredientLevelsStorage.getAmountWater() <= CapacityLimits.COFFEE_RECIPE_WATER_BASED){
            System.out.println("Не хватает воды!");
            promptDrinkMenu();
        }
        if(IngredientLevelsStorage.getAmountMilk() <= CapacityLimits.COFFEE_RECIPE_MILK_BASED){
            System.out.println("Вам не хватает молока!");
        }
        if(IngredientLevelsStorage.getAmountCoffee() <= CapacityLimits.COFFEE_RECIPE_COFFEE_BASED){
            System.out.println("Вам не хватает кофе!");
            promptDrinkMenu();
        }
    }
    // Приготовления эспрессо
    public void espressoPreparation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите кол-во кружек которое хотите сделать: ");
        int inputCountCup = sc.nextInt();
        if(inputCountCup > 0){
            validateCupCount(inputCountCup);
            beverageCoffeeEspresso(inputCountCup);
        }else{
            System.out.println("Введите правильное число!");
            espressoPreparation();
        }
        promptDrinkMenu();
    }
    // Приготовление капучино.
    public void cappuccinoPreparation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите кол-во кружек которое хотите сделать: ");
        int inputCountCup = scanner.nextInt();
        if(inputCountCup > 0){
            validateCupCount(inputCountCup);
            beverageCoffeeCappuccino(inputCountCup);
        }else{
            System.out.println("Введите правильное число!");
            cappuccinoPreparation();
        }
        promptDrinkMenu();
    }

    public void prepareThreeDrinksCappuccino(){
        if(CapacityLimits.getCountCup() + 3 >= MAX_COUNT_CUP){
            System.out.println("Кофе-машина забилась!");
            CapacityLimits.setCountCup(MAX_COUNT_CUP);
            System.out.println("Кол-во кружек = " + CapacityLimits.getCountCup());
            promptDrinkMenu();
        }
        beverageCoffeeCappuccino(3);
        System.out.println("Мы приготовили сразу 3 напитка!" +
                "\nНапиток который мы сделали: Капучино" +
                "\nКол-кружек : " + CapacityLimits.getCountCup());
        promptDrinkMenu();
    }
    public void beverageCoffeeCappuccino(int inputCountCup){
        for(int i = 1; i <= inputCountCup; i++ ){
            validateIngredientLevelsStorageCappuccino();
            IngredientLevelsStorage.setAmountWater(IngredientLevelsStorage.getAmountWater() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            IngredientLevelsStorage.setAmountCoffee(IngredientLevelsStorage.getAmountCoffee() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            IngredientLevelsStorage.setAmountMilk(IngredientLevelsStorage.getAmountMilk() - CapacityLimits.COFFEE_RECIPE_MILK_BASED);
            countCup++;
            cappuccinoCount++;
        }
    }

    public void beverageCoffeeEspresso(int inputCountCup){
        for(int i = 1; i <= inputCountCup; i++ ){
            validateIngredientLevelsStorageEspresso();
            IngredientLevelsStorage.setAmountWater(IngredientLevelsStorage.getAmountWater() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            IngredientLevelsStorage.setAmountCoffee(IngredientLevelsStorage.getAmountCoffee() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            countCup++;
            espressoCount++;
        }
    }

    public void prepareThreeDrinksEspresso(){
        if(CapacityLimits.getCountCup() + 3 >= MAX_COUNT_CUP){
            System.out.println("Кофе-машина забилась!");
            CapacityLimits.setCountCup(MAX_COUNT_CUP);
            System.out.println("Кол-во кружек = " + CapacityLimits.getCountCup());
            promptDrinkMenu();
        }
        beverageCoffeeEspresso(3);
        System.out.println("Мы приготовили сразу 3 напитка!" +
                "\nНапиток который мы сделали: Эспрессо" +
                "\nКол-кружек : " + CapacityLimits.getCountCup());
        promptDrinkMenu();
    }
    public void prepareForProfile(){
        System.out.println("Тут мы будем готовить по имени профилю!!!!!!");
        promptDrinkMenu();
    }
}