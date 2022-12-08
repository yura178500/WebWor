package ru.example.webwor.controlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.webwor.controlers.services.RecipesService;

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
    }}