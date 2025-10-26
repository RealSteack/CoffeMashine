package org.example.quantity;

import org.example.displays.Display;

import java.util.Scanner;

import static org.example.ingridients.Ingridients.*;

public class QuantityMachine {
    public int amountMilk = 1000 ;
    public int amountCoffee = 300;
    public int amountWater = 1000;

    Scanner scanner = new Scanner(System.in);

    public int getAmountMilk() {
        return amountMilk;
    }

    public void setAmountMilk(int amountMilk) {
        this.amountMilk = amountMilk;
    }

    public int getAmountCoffee() {
        return amountCoffee;
    }

    public void setAmountCoffee(int amountCoffee) {
        this.amountCoffee = amountCoffee;
    }

    public int getAmountWater() {
        return amountWater;
    }

    public void setAmountWater(int amountWater) {
        this.amountWater = amountWater;
    }

    public int addQuantityWater(){
        System.out.println("Введите количество воды: ");
        int quantityWatterAmount = scanner.nextInt();
        if(quantityWatterAmount > MAX_COUNT_WATER || amountWater > MAX_COUNT_WATER){
            System.out.println("Вы превысили лимит!");
        }
        if(quantityWatterAmount < MAX_COUNT_WATER && (amountWater + quantityWatterAmount) <= MAX_COUNT_WATER && quantityWatterAmount > 0 ){
            amountWater = amountWater + quantityWatterAmount;
        } else if ((amountWater + quantityWatterAmount) > MAX_COUNT_WATER) {
            System.out.println("ПРЕВЫШЕН ЛИМИТ 1К!");
            amountWater = MAX_COUNT_WATER;
        }
        return quantityWatterAmount;
    }
    public int addQuantityCoffee(){
        System.out.println("Введите количество кофе: ");
        int quantityCoffeeAmount = scanner.nextInt();
        if(quantityCoffeeAmount > MAX_COUNT_COFFEE || amountCoffee > MAX_COUNT_COFFEE){
            System.out.println("Вы превысили лимит!");
        }
        if(quantityCoffeeAmount < MAX_COUNT_COFFEE && (amountCoffee + quantityCoffeeAmount) <= MAX_COUNT_COFFEE && quantityCoffeeAmount > 0 ){
            amountCoffee = amountCoffee + quantityCoffeeAmount;
        } else if ((amountCoffee + quantityCoffeeAmount) > MAX_COUNT_COFFEE) {
            System.out.println("ПРЕВЫШЕН ЛИМИТ 500гр!");
            amountCoffee = MAX_COUNT_COFFEE;
        }
        return quantityCoffeeAmount;
    }
    public int addQuantityMilk(){
        Display display = new Display();
        System.out.println("Введите количество молока : ");
        int quantityMilkAmount = scanner.nextInt();
        if(quantityMilkAmount > MAX_COUNT_MILK || amountMilk > MAX_COUNT_MILK){
            System.out.println("Вы превысили лимит!");
        }
        if(quantityMilkAmount < MAX_COUNT_MILK && (amountMilk + quantityMilkAmount) <= MAX_COUNT_MILK && quantityMilkAmount > 0 ){
            amountMilk = amountMilk + quantityMilkAmount;
        } else if ((amountMilk + quantityMilkAmount) > MAX_COUNT_MILK) {
            System.out.println("ПРЕВЫШЕН ЛИМИТ 1К!");
            amountMilk = MAX_COUNT_MILK;
        }
        return quantityMilkAmount;
    }

}
