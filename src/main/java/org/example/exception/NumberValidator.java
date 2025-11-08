package org.example.exception;

public class NumberValidator {

    public void validateNumberDetailed(int number) {
        if (number < 0) {
            throw new NegativeNumberException(
                    String.format(
                            "Ошибка! Ожидалось число >= 0, но получено: %d. " +
                                    "Пожалуйста, введите корректное значение.",
                            number
                    )
            );
        }
    }
}
