package org.example.ingredientLevelsStorage;

import org.example.displays.DisplayInfo;

import java.util.Scanner;

public class IngredientDispenser {
    static DisplayInfo displayInfo = new DisplayInfo();
    
    public void askUserWhatToAdd(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Что вы хотите наполнить? " +
                "\n1.Кофе" +
                "\n2.Воду" +
                "\n3.Молоко");
        switch (sc.nextLine()){
            case "1" -> addCoffeeMount();
            case "2" -> addWaterMount();
            case "3" -> addMilkMount();
            default->{
                System.out.println("Такой команды увы нет");
                displayInfo.displayInfo();
            }
        }
    }

    void addCoffeeMount(){
        System.out.println("Кофе");
    }

    void addMilkMount(){
        System.out.println("Молоко");
    }

    void addWaterMount(){
        System.out.println("Вода");
    }

}
