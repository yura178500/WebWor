package ru.example.webwor.controlers.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface Ingredient {
    String getNameIngredient();
    int getNumberIngredients();
    String getUnit();

    Long getIdIngredient();


    public class IngredientService {
        private Map<Long, Ingredient> ingredientMap = new HashMap<>();
        private Long generatedIngredientId = 1L;

        public Ingredient createIngredient(Ingredient ingredient) {
            ingredientMap. put(generatedIngredientId, ingredient);
            generatedIngredientId++;
            return ingredient;
        }

        public Ingredient getIngredientById(Long ingredientId) {
            return ingredientMap.get(ingredientId);
        }

        public Ingredient updateIngredient(Long ingredientId, Ingredient ingredient) {
            ingredientMap.put(ingredientId, ingredient);
            return ingredient;
        }


        public Ingredient deleteIngredient(Long ingredientId) {
            return ingredientMap.remove(ingredientId);
        }
    }
}
