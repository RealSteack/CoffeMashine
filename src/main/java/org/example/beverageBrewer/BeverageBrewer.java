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
        System.out.println("====ВЫБЕРИТЕ КОФЕ ====" +
                "\n1.Эспрессо" +
                "\n2.Капучино" +
                "\n3.Приготовить 3 Капучино" +
                "\n4.Приготовить 3 Эспрессо" +
                "\n5.Выйти");
        switch(sc.nextLine()){
            case "1" -> espressoPreparation();
            case "2" -> cappuccinoPreparation();
            case "3" -> prepareThreeDrinksCappuccino();
            case "4" -> prepareThreeDrinksEspresso();
            case "5" -> displayInfo.displayInfo();
            default -> promptDrinkMenu();
        }
    }

    public void validateIngredientLevelsStorage(){
        if(IngredientLevelsStorage.getAmountWater() <= CapacityLimits.COFFEE_RECIPE_WATER_BASED){
            System.out.println("Не хватает воды!");
        }
        if(IngredientLevelsStorage.getAmountMilk() <= CapacityLimits.COFFEE_RECIPE_MILK_BASED){
            System.out.println("Вам не хватает молока");
        }
        if(IngredientLevelsStorage.getAmountCoffee() <= CapacityLimits.COFFEE_RECIPE_COFFEE_BASED){
            System.out.println("Вам не хватает кофе!");
        }
    }
        public void validateCupCount(int inputCountCup ){
        if((countCup + inputCountCup) >= MAX_COUNT_CUP){
            System.out.println("Необходимо очистить кофе-машину!");
            CapacityLimits.setCountCup(MAX_COUNT_CUP);
            promptDrinkMenu();
        }
    }

    public void espressoPreparation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите кол-во кружек которое хотите сделать: ");
        int inputCountCup = sc.nextInt();
        if(inputCountCup > 0){
            validateCupCount(inputCountCup);
            for(int i = 1; i <= inputCountCup; i++ ){
                validateIngredientLevelsStorage();
                IngredientLevelsStorage.setAmountWater(IngredientLevelsStorage.getAmountWater() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
                IngredientLevelsStorage.setAmountCoffee(IngredientLevelsStorage.getAmountCoffee() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
                countCup++;
                espressoCount++;
            }
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
            for(int i = 1; i <= inputCountCup; i++ ){
                validateIngredientLevelsStorage();
                IngredientLevelsStorage.setAmountWater(IngredientLevelsStorage.getAmountWater() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
                IngredientLevelsStorage.setAmountCoffee(IngredientLevelsStorage.getAmountCoffee() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
                IngredientLevelsStorage.setAmountMilk(IngredientLevelsStorage.getAmountMilk() - CapacityLimits.COFFEE_RECIPE_MILK_BASED);
                countCup++;
                cappuccinoCount++;
            }
        }else{
            System.out.println("Введите правильное число!");
            cappuccinoPreparation();
        }
        promptDrinkMenu();
    }

    public void prepareThreeDrinksCappuccino(){
        if(countCup + 3 >= MAX_COUNT_CUP){
            System.out.println("Кофе-машина забилась!");
            countCup = MAX_COUNT_CUP;
            System.out.println("Кол-во кружек = " + countCup);
            promptDrinkMenu();
        }
        for(int i = 1; i <= 3; i++ ){
            validateIngredientLevelsStorage();
            IngredientLevelsStorage.setAmountWater(IngredientLevelsStorage.getAmountWater() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            IngredientLevelsStorage.setAmountCoffee(IngredientLevelsStorage.getAmountCoffee() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            IngredientLevelsStorage.setAmountMilk(IngredientLevelsStorage.getAmountMilk() - CapacityLimits.COFFEE_RECIPE_MILK_BASED);
            countCup++;
            cappuccinoCount++;
        }
        System.out.println("Мы приготовили сразу 3 напитка!" +
                "\nНапиток который мы сделали: Капучино" +
                "\nКол-кружек : " + countCup);
        promptDrinkMenu();
    }

    public void prepareThreeDrinksEspresso(){
        if(countCup + 3 >= MAX_COUNT_CUP){
            System.out.println("Кофе-машина забилась!");
            countCup = MAX_COUNT_CUP;
            System.out.println("Кол-во кружек = " + countCup);
            promptDrinkMenu();
        }
        for(int i = 1; i <= 3; i++ ){
            validateIngredientLevelsStorage();
            IngredientLevelsStorage.setAmountWater(IngredientLevelsStorage.getAmountWater() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            IngredientLevelsStorage.setAmountCoffee(IngredientLevelsStorage.getAmountCoffee() - CapacityLimits.COFFEE_RECIPE_WATER_BASED);
            countCup++;
            espressoCount++;
        }
        System.out.println("Мы приготовили сразу 3 напитка!" +
                "\nНапиток который мы сделали: Эспрессо" +
                "\nКол-кружек : " + countCup);
        promptDrinkMenu();
    }
}