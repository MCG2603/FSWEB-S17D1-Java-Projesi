package com.example.demo.mapping;

import entity.Animal;

public class AnimalResponse {
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getMessage() {
        return message;
    }

    private Animal animal;
    private String message;


    public AnimalResponse(Animal animal, String message) {
        this.animal = animal;
        this.message = message;
    }
}
