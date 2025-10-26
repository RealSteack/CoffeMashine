package org.example.prepare;

import org.example.quantity.QuantityMachine;

import java.util.Scanner;

public class Prepare {
    public int cupCountQuantity = 0;
    public int cup;
    private final QuantityMachine quantityMachine;
    public int MAX_COUNT_QUANTITY_CUP = 5;
    Scanner sc = new Scanner(System.in);

    public Prepare(QuantityMachine quantityMachine) {
        this.quantityMachine = quantityMachine;
    }

    public void espressoPreparation() {
        System.out.println("Введите кол-во кружек; ");
        cupCountQuantity = sc.nextInt();
        if (cupCountQuantity > MAX_COUNT_QUANTITY_CUP) {
            System.out.println("Ошибка!, такое кол-во кружек не возможно!");
        }
        if (cupCountQuantity < MAX_COUNT_QUANTITY_CUP && cup < MAX_COUNT_QUANTITY_CUP && (cup + cupCountQuantity) < MAX_COUNT_QUANTITY_CUP) {
            if(quantityMachine.amountWater > 0){
                if(quantityMachine.amountCoffee > 0){
                    if(quantityMachine.amountMilk > 0){
                        for (int i = 0; i < cupCountQuantity; i++) {
                            quantityMachine.amountWater = quantityMachine.amountWater - 50;
                            quantityMachine.amountCoffee = quantityMachine.amountCoffee - 10;
                            quantityMachine.amountMilk = quantityMachine.amountMilk - 50;
                            cup++;
                        }
                        System.out.println("Кол-во кружек которые мы приготовили :" + cupCountQuantity +
                                "\nМы приготовили : Эспрессо! ");
                        System.out.println("Сейчас у нас кружек: " + cup);
                    }else{
                        System.out.println("Вам не хватает молока!");
                    }
                }else{
                    System.out.println("Вам не хватает кофе!");
                }
            }else{
                System.out.println("Вам не хватает воды!");
            }
        }else{
            System.out.println("ВАМ НУЖНО ОЧИСТИТЬ КОФЕ МАШИНУ! = " + cup);
        }
    }
    public void cappuccinoPreparation() {
        System.out.println("Введите кол-во кружек; ");
        cupCountQuantity = sc.nextInt();
        if (cupCountQuantity > MAX_COUNT_QUANTITY_CUP) {
            System.out.println("Ошибка!, такое кол-во кружек не возможно!");
        }
        if (cupCountQuantity < MAX_COUNT_QUANTITY_CUP && cup < MAX_COUNT_QUANTITY_CUP && (cup + cupCountQuantity) < MAX_COUNT_QUANTITY_CUP) {
            if(quantityMachine.amountWater > 0){
                if(quantityMachine.amountCoffee > 0){
                    if(quantityMachine.amountMilk > 0){
                        for (int i = 0; i < cupCountQuantity; i++) {
                            quantityMachine.amountWater = quantityMachine.amountWater - 50;
                            quantityMachine.amountCoffee = quantityMachine.amountCoffee - 10;
                            quantityMachine.amountMilk = quantityMachine.amountMilk - 50;
                            cup++;
                        }
                        System.out.println("Кол-во кружек которые мы приготовили :" + cupCountQuantity +
                                "\nМы приготовили : Капучино! ");
                    }else{
                        System.out.println("Вам не хватает молока!");
                    }
                }else{
                    System.out.println("Вам не хватает кофе!");
                }
            }else{
                System.out.println("Вам не хватает воды!");
            }
        }else{
            System.out.println("ВАМ НУЖНО ОЧИСТИТЬ КОФЕ МАШИНУ! = " + cup);
        }
    }
    public void espressoPreparationX3(){
        int cupCountQuantity = 3;
        if(quantityMachine.amountWater > 0){
            if(quantityMachine.amountCoffee > 0){
                if(quantityMachine.amountMilk > 0){
                    for (int i = 0; i < 3; i++) {
                        quantityMachine.amountWater = quantityMachine.amountWater - 50;
                        quantityMachine.amountCoffee = quantityMachine.amountCoffee - 10;
                        quantityMachine.amountMilk = quantityMachine.amountMilk - 50;
                    }
                    System.out.println("Кол-во кружек которые мы приготовили :" + cupCountQuantity +
                            "\nМы приготовили : Капучино! ");
                }else{
                    System.out.println("Вам не хватает молока!");
                }
            }else{
                System.out.println("Вам не хватает кофе!");
            }
        }else{
            System.out.println("Вам не хватает воды!");
        }
    }
    public void cappuccinoPreparationX3(){
        int cupCountQuantity = 3;
        if(quantityMachine.amountWater > 0){
            if(quantityMachine.amountCoffee > 0){
                if(quantityMachine.amountMilk > 0){
                    for (int i = 0; i < 3; i++) {
                        quantityMachine.amountWater = quantityMachine.amountWater - 50;
                        quantityMachine.amountCoffee = quantityMachine.amountCoffee - 10;
                        quantityMachine.amountMilk = quantityMachine.amountMilk - 50;
                    }
                    System.out.println("Кол-во кружек которые мы приготовили :" + cupCountQuantity +
                            "\nМы приготовили : Эспрессо! ");
                }else{
                    System.out.println("Вам не хватает молока!");
                }
            }else{
                System.out.println("Вам не хватает кофе!");
            }
        }else{
            System.out.println("Вам не хватает воды!");
        }
    }
}
