package org.example.beverageBrewer;

import org.example.capacityLimits.CapacityLimits;
import org.example.displays.DisplayInfo;
import org.example.ingredientLevelsStorage.IngredientLevelsStorage;
import org.example.profiles.CoffeeProfile;


import java.util.Scanner;

import static org.example.capacityLimits.CapacityLimits.*;
import static org.example.profiles.ProfileManager.users;

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
                5.Приготовить по профилю
                6.Выйти""");
        switch(sc.nextLine()){
            case "1" -> espressoPreparation();
            case "2" -> cappuccinoPreparation();
            case "3" -> prepareThreeDrinksCappuccino();
            case "4" -> prepareThreeDrinksEspresso();
            case "5" -> prepareDrinkToProfile();
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
    // Проверка на превышение максимальное кол-во кружек в кофе-машине по профилю
    public void validateCupCountProfile(){
        if(CapacityLimits.getCountCup()  >= MAX_COUNT_CUP){
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
            CapacityLimits.setCountCup(CapacityLimits.getCountCup()+ 1);
            CapacityLimits.setCappuccinoCount(CapacityLimits.getCappuccinoCount() + 1);
        }
    }

    public void beverageCoffeeEspresso(int inputCountCup){
        for(int i = 1; i <= inputCountCup; i++ ){
            validateIngredientLevelsStorageEspresso();
            IngredientLevelsStorage.setAmountWater(IngredientLevelsStorage.getAmountWater() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            IngredientLevelsStorage.setAmountCoffee(IngredientLevelsStorage.getAmountCoffee() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            CapacityLimits.setCountCup(CapacityLimits.getCountCup() + 1);
            CapacityLimits.setEspressoCount(CapacityLimits.getCappuccinoCount() + 1);
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

    public void prepareDrinkToProfile(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя профиля: ");
        String name = sc.nextLine();
        CoffeeProfile profile = users.get(name);
        if (users.containsKey(name)) {
            CapacityLimits.setCoupCountProfileEspresso(profile.getCoupCountEspresso());
            CapacityLimits.setCoupCountProfileCappuccino(profile.getCoupCountCappuccino());
            espressoDrinkToProfile();
            cappuccinoDrinkToProfile();
            System.out.println("По профилю : " + name +
                    "\nКружек   -> " + CapacityLimits.getCountCup()+
                    "\nЭспрессо -> " + CapacityLimits.getCoupCountProfileCappuccino()+
                    "\nКапучино -> " + CapacityLimits.getCoupCountProfileEspresso());
            promptDrinkMenu();
        } else {
            System.out.println("Такого пользователя не существует!");
            promptDrinkMenu();
        }
    }

    public void espressoDrinkToProfile(){
        for(int i = 1; i <= CapacityLimits.getCoupCountProfileEspresso(); i++ ){
            validateCupCountProfile();
            validateIngredientLevelsStorageEspresso();
            IngredientLevelsStorage.setAmountWater(IngredientLevelsStorage.getAmountWater() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            IngredientLevelsStorage.setAmountCoffee(IngredientLevelsStorage.getAmountCoffee() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            CapacityLimits.setCountCup(CapacityLimits.getCountCup() + 1);
            CapacityLimits.setEspressoCount(CapacityLimits.getEspressoCount() + 1);
        }
    }

    public void cappuccinoDrinkToProfile(){
        for(int i = 1; i <= CapacityLimits.getCoupCountProfileCappuccino(); i++ ){
            validateCupCountProfile();
            validateIngredientLevelsStorageCappuccino();
            IngredientLevelsStorage.setAmountWater(IngredientLevelsStorage.getAmountWater() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            IngredientLevelsStorage.setAmountCoffee(IngredientLevelsStorage.getAmountCoffee() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            IngredientLevelsStorage.setAmountMilk(IngredientLevelsStorage.getAmountMilk() - CapacityLimits.COFFEE_RECIPE_MILK_BASED);
            CapacityLimits.setCountCup(CapacityLimits.getCountCup() + 1);
            CapacityLimits.setCappuccinoCount(CapacityLimits.getCappuccinoCount() + 1);
        }
    }
}