package com.example.VetApp.service;

import java.util.List;

import com.example.VetApp.model.Animal;

public interface AnimalService {
	List<Animal> getAnimals();
	void saveAnimal(Animal animal);
	Animal getAnimalById(long id);
	void deleteAnimal(long id);
	List<Animal> findBySearchText(String text);
}
