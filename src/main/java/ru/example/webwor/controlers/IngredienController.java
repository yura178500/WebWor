package ru.example.webwor.controlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.webwor.controlers.services.Ingredient;

@RequestMapping("ingredien")
@RestController
class IngredienController {
    private Ingredient.IngredientService ingredientService;

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
        if (ingredient == null) {
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
