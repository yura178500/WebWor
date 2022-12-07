package ru.example.webwor.controlers.services;

import java.util.HashMap;
import java.util.Map;

public interface RecipesService {
    String getName();
    int getCookingTime();
    String getIngredients();
    String getCookingSteps();

        Map<Long, RecipesService> recipes = new HashMap<>();
        Long getRecipesId = 1L;

        public static RecipesService createRecipes(RecipesService recipes) {
            recipes.put(getRecipesId, recipes);

            return recipes;
        }

    void put(Long generatedRecipesId, RecipesService recipes);

    public static RecipesService getRecipesId(Long recipesId) {
            return recipes.get(recipesId);
        }

        public static RecipesService updateRecipes(Long recipesId, RecipesService recipes) {
            RecipesService.recipes.put(recipesId, (RecipesService) RecipesService.recipes);
            return recipes;
        }


        public static RecipesService deleteRecipes(Long recipesId) {
            return recipes.remove(recipesId);
        }

    Long getId();
}

