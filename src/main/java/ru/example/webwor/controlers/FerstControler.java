package ru.example.webwor.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class FerstControler {

    @GetMapping
    public String applicationIsRunning(){
        return "Приложение запущено";
    }
    @GetMapping("/info")
    public String info(String name, String  nameProject, LocalDate dateProject,String descriptionProject){
        name = "Юрий";
        nameProject = "Вебразработка";
        dateProject = LocalDate.now();
        descriptionProject = "Вебразработка";
        return "Приложение запущено" + "/" + name +"/" +nameProject+ "/" +dateProject+ "/" + descriptionProject;
    }
}
