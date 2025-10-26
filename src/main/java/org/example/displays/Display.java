package org.example.displays;

import org.example.prepare.Prepare;
import org.example.quantity.QuantityMachine;

import java.util.Scanner;

public class Display {
    QuantityMachine quantityMachine = new QuantityMachine();
    Scanner scanner = new Scanner(System.in);
    Prepare prepare = new Prepare(quantityMachine);

    public void addWater(){
        quantityMachine.addQuantityWater();
        displayInfo();
    }
    public void addCoffee(){
        quantityMachine.addQuantityCoffee();
        displayInfo();
    }
    public void addMilk(){
        quantityMachine.addQuantityMilk();
        displayInfo();
    }
    public void displayInfo(){
        System.out.println("""
                           Доступные функции:\s
                           1. Добавить воды
                           2. Добавить кофе
                           3. Добавить молока
                           4. Приготовить эспрессо
                           5. Приготовить капучино
                           6. Кол-во в машине
                           7. Приготовить 3 эспрессо
                           8. Приготовить 3 капучино
                           9. Выйти""");
        int added_ingridients = scanner.nextInt();
        switch(added_ingridients){
            case 1:
                addWater();
                break;
            case 2:
                addCoffee();
                break;
            case 3:
                addMilk();
                break;
            case 4:
                prepare.espressoPreparation();
                displayInfo();
            case 5:
                prepare.cappuccinoPreparation();
                displayInfo();
            case 6:
                System.out.println("На данный момент в кофе-машине находятся такие ингридиенты:\n" +
                        "Количество воды : " + quantityMachine.getAmountWater() +
                        "\nКоличество кофе : " + quantityMachine.getAmountCoffee() +
                        "\nКоличество молока: " + quantityMachine.getAmountMilk() );
                displayInfo();
            case 7:
                prepare.espressoPreparationX3();
                displayInfo();
            case 8:
                break;
            case 9:
                break;



        }
    }

}