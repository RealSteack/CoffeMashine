package org.example.displays;

import java.util.Scanner;

public class StartMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DisplayInfo display = new DisplayInfo();

        System.out.println("""
                Вы хотите включить кофе-машину?
                1.Да
                2.Нет""");

        switch (sc.nextLine()) {
            case "1" -> display.displayInfo();
            case "2" -> System.out.println("До свидания!");
            default  -> System.err.println("Ошибка!");
        }
    }
}
