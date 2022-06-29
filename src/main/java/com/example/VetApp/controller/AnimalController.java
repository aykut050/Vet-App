package com.example.VetApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.VetApp.model.Animal;
import com.example.VetApp.service.AnimalService;
import com.example.VetApp.service.UserService;

@Controller
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("listOfAnimals", animalService.getAnimals());
		model.addAttribute("listOfUser", userService.getUsers());
		return "index";
	}
	
	@GetMapping("/animals")
	public String getAnimals(Model model, String text) {
		if (text != null) {
			model.addAttribute("listOfAnimals", animalService.findBySearchText(text));
		} 
		else
		{
			model.addAttribute("listOfAnimals", animalService.getAnimals());
		}
		model.addAttribute("listOfUser", userService.getUsers());
		return "index";
	}
	
	@GetMapping("/users")
	public String getUsers(Model model, String text) {
		if (text != null) {
			model.addAttribute("listOfUser", userService.findBySearchTextUser(text));
		} 
		else
		{
			model.addAttribute("listOfUser", userService.getUsers());
		}
		model.addAttribute("listOfAnimals", animalService.getAnimals());
		return "index";
	}
	
	@GetMapping("/getAnimalFormToAdd")
	public String getAnimalFormToAdd(Model model) {
		Animal animal = new Animal();
		model.addAttribute("animal", animal);
		model.addAttribute("listOfUser", userService.getUsers());
		return "add_animal_form";
	}
	
	@PostMapping("/saveAnimal")
	public String saveAnimal(@ModelAttribute("animal") Animal animal) {
		animalService.saveAnimal(animal);
		return "redirect:/";
	}
	
	@GetMapping("/getAnimalFormToUpdate/{id}")
	public String getAnimalFormToUpdate(@PathVariable (value = "id") long id, Model model) {
		Animal animal = animalService.getAnimalById(id);
		model.addAttribute("animal", animal);
		model.addAttribute("listOfUser", userService.getUsers());
		return "update_animal_form";
	}
	
	@GetMapping("/deleteAnimal/{id}")
	public String deleteAnimal(@PathVariable (value = "id") long id) {
		this.animalService.deleteAnimal(id);
		return "redirect:/";
	}
}
