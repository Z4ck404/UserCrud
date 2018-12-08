package springbootapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootapi.dao.UserRepository;
import springbootapi.dto.UserDTO;
import springbootapi.entities.User;
import springbootapi.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping(path = { "/users/{id}" })
	public UserDTO findOne(@PathVariable("id") Long id) {
		return userService.findUser(id);
	}

	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return userRepository.save(user);

	}

	@PutMapping("/users")
	public User update(@RequestBody User user) {
		return userRepository.saveAndFlush(user);
	}

	@DeleteMapping(path = { "/users/{id}" })
	public void delete(@PathVariable("id") Long id) {
		
		userRepository.deleteById(id);
		
	}
}
