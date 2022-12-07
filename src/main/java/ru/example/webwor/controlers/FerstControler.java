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



    }
}
