package com.example.VetApp.service;

import java.util.List;

import com.example.VetApp.model.Animal;
import com.example.VetApp.model.User;

public interface UserService {
	List<User> getUsers();
	void saveUser(User user);
	User getUserById(long id);
	void deleteUser(long id);
	List<User> findBySearchTextUser(String text);
}
