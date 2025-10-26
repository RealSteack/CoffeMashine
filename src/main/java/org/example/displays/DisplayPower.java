package org.example.displays;

public class DisplayPower {
    void speakInput(){
        System.out.println("""
                Вы хотите включить кофе-машину?
                1.Да
                2.Нет""");
    }
    void speakOutput(){
        System.out.println("Вы закончили работу кофе-машины!");
    }
}
