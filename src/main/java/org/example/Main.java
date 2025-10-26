package org.example;

import org.example.displays.Display;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        Scanner sc = new Scanner(System.in);

        System.out.println("Вы хотите включить кофе машину? :\n" +
                "           1. Да\n" +
                "           2. Нет.\n");
        String input = sc.nextLine();

        switch (input) {
            case "1":
                display.displayInfo();
        }

    }
}