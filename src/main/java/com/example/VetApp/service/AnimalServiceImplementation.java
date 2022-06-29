package com.example.VetApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VetApp.model.Animal;
import com.example.VetApp.repository.AnimalRepository;

@Service
public class AnimalServiceImplementation implements AnimalService {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Override
	public List<Animal> getAnimals() {
		return animalRepository.findAll();
	}

	@Override
	public void saveAnimal(Animal animal) {
		this.animalRepository.save(animal);
	}
	
	@Override
	public Animal getAnimalById(long id) {
		Optional<Animal> optional = animalRepository.findById(id);
		Animal animal = null;
		if (optional.isPresent()) {
			animal = optional.get();
		} 
		else {
			throw new RuntimeException("Hayvan bulunamadı.");
		}
		return animal;
	}

	@Override
	public void deleteAnimal(long id) {
		this.animalRepository.deleteById(id);
	}
	
	public List<Animal> findBySearchText(String text) {
		return animalRepository.findBySearchText(text);
	}
	
}
