package org.example.coffeeRecipeType;

public enum CoffeeRecipeType {
    CAPPUCCINO("""
            Рецепт Капучино:
            Вода: 100мл
            Кофе: 25гр
            
            """),
    ESPRESSO("""
            Рецепт Эспрессо:
            Вода: 100мл
            Кофе: 25гр
            Молоко: 35мл
            
            """);

    private final String recipe;

    CoffeeRecipeType(String recipe) {
        this.recipe = recipe;
    }

    public String getRecipe() {
        return recipe;
    }
}
