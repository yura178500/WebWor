package ru.example.webwor.controlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.webwor.controlers.services.Ingredient;
import ru.example.webwor.controlers.services.RecipesService;

import java.time.LocalDate;

@RestController
public class FerstControler {

    @GetMapping
    public String applicationIsRunning() {
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String info(String name, String nameProject, LocalDate dateProject, String descriptionProject) {
        name = "Юрий";
        nameProject = "Вебразработка";
        dateProject = LocalDate.now();
        descriptionProject = "Вебразработка";
        return "Приложение запущено" + "/" + name + "/" + nameProject + "/" + dateProject + "/" + descriptionProject;

        @RequestMapping("recipes")
        @RestController
        class RecipesController {
            public RecipesService recipesService;

            public RecipesController(RecipesService recipesService) {
                this.recipesService = recipesService;
            }

            @PostMapping
            public ResponseEntity createRecipes(@RequestBody RecipesService recipes) {
                RecipesService createdRecipes = RecipesService.createRecipes(recipes);
                return ResponseEntity.ok(createdRecipes);
            }

            @GetMapping("{recipesId}")
            public ResponseEntity getRecipes(@PathVariable Long recipesId) {
                RecipesService recipes = RecipesService.getRecipesId(recipesId);
                if (recipes == null) {
                    return ResponseEntity.notFound().build();
                }
                return ResponseEntity.ok(recipes);
            }

            @PutMapping()
            public ResponseEntity updateRecipes(@RequestBody RecipesService recipes) {
                RecipesService updatedRecipes = RecipesService.updateRecipes(recipes.getId(), recipes);
                return ResponseEntity.ok(updatedRecipes);
            }

            @GetMapping("/api/recipes/{id}/{name}")
            @ResponseBody
            public String RecipesController(@PathVariable String id, @PathVariable String name) {
                return "ID: " + id + ", name: " + name;
            }
            @RequestMapping("ingredien")
            @RestController
            class IngredienController {
                private final Ingredient.IngredientService ingredientService;

                public IngredienController(Ingredient.IngredientService ingredientService) {
                    this.ingredientService = ingredientService;
                }

                @PostMapping
                public ResponseEntity createIngredien(@RequestBody Ingredient ingredient) {
                    Ingredient createIngredien = ingredientService.createIngredient(ingredient);
                    return ResponseEntity.ok(createIngredien);
                }

                @GetMapping("{ingredienId}")
                public ResponseEntity getIngredien(@PathVariable Long ingredientId) {
                    Ingredient ingredient = ingredientService.getIngredientById(ingredientId);
                    if(ingredient == null) {
                        return ResponseEntity.notFound().build();
                    }
                    return ResponseEntity.ok(ingredient);
                }

                @PutMapping()
                public ResponseEntity updateIngredien(@RequestBody Ingredient ingredient) {
                    Ingredient updatedIngredient = ingredientService.updateIngredient(ingredient.getIdIngredient(), ingredient);
                    return ResponseEntity.ok(updatedIngredient);
                }
                @GetMapping("/api/ingredient/{id}/{name}")
                @ResponseBody
                public String IngredienController(@PathVariable String idIngredient, @PathVariable String nameIngredien) {
                    return "ID: " + idIngredient + ", name: " + nameIngredien;
                }
            }
        }

    }
}
