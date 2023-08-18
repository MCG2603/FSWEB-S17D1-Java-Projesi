package com.example.demo.controller;


import com.example.demo.mapping.AnimalResponse;
import entity.Animal;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {

    @Value("${instructor.name}")
    private String name;
private Map<Integer, Animal> animalMap;
    @Value("${instructor.surname}")
    private String surname;
    @PostConstruct
    public void init(){
        animalMap=new HashMap<>();
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Animal Controller has been destroy");
    }
    @GetMapping("/welcome")
    public String welcome(){
        return name+""+surname+ "says hi";
    }
    public List<Animal> get(){
        return animalMap.values().stream().toList();
    }
    @GetMapping("/{id}")
    public AnimalResponse get(@PathVariable int id){
        if(id<0){
            return new AnimalResponse(null,"Böyle bir hayvan yok");
        }
        if(!animalMap.containsKey(id)){
            return new AnimalResponse(null,"Böyle bir hayvan yok");

        }
        return new AnimalResponse(animalMap.get(id),"success");
    }
    @PostMapping ("/")
    public AnimalResponse post(@RequestBody Animal animal){
        if(animalMap.containsKey(animal.getId())){
            Animal a=new Animal();
            return new AnimalResponse(a,"Bu id li başka bir hayvan mevcut");

        }
        Animal b=new Animal();
        animalMap.put(animal.getId(), animal);
        return  new AnimalResponse(b,"success");


    }

}
