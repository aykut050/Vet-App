package com.example.VetApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VetApp.model.User;
import com.example.VetApp.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		this.userRepository.save(user);
	}
	
	@Override
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} 
		else {
			throw new RuntimeException("Hayvan bulunamadı.");
		}
		return user;
	}

	@Override
	public void deleteUser(long id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public List<User> findBySearchTextUser(String text) {
		return userRepository.findBySearchTextUser(text);
	}

}
