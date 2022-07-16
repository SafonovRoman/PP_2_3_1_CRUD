package ru.safonovroman.kata.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.safonovroman.kata.crud.service.UserService;

@Controller
public class UsersController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/users")
	public String showAllUsers(ModelMap model) {
		model.addAttribute("users", userService.listUsers());
		return "users";
	}

	@GetMapping(value = "/user/{id}")
	public String showUser(ModelMap model, @RequestParam(value = "id", defaultValue = "1") Long id) {
		model.addAttribute("user", userService.getUser(id));
		return "user";
	}

	@GetMapping(value = "/user/{id}/delete")
	public String deleteUser(ModelMap model, @PathVariable("id") Long id) {
		userService.delete(id);
		return showAllUsers(model);
	}
}