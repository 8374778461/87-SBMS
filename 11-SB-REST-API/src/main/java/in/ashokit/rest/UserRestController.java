package in.ashokit.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.dto.User;
import in.ashokit.exception.NoUserFoundException;
import in.ashokit.repo.UserRepo;

@RestController
public class UserRestController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping(value = "/users", produces = { "application/xml", "application/json" })
	public ResponseEntity<List<User>> getUsers() {

		List<User> usersList = userRepo.findAll();

		return ResponseEntity.status(200).body(usersList);
	}

	@GetMapping(value = "/user/{userId}", produces = { "application/xml", "application/json" })
	public ResponseEntity<User> getUserById(@PathVariable Integer userId) {

		Optional<User> user = userRepo.findById(userId);

		if (user.isPresent()) {
			return ResponseEntity.status(200).body(user.get());
		} else {
			return ResponseEntity.status(400).body(null);
		}
	}

	@GetMapping(value = "/user", produces = { "application/xml", "application/json" })
	public ResponseEntity<User> getUser(@RequestParam("userId") Integer userId) {

		Optional<User> user = userRepo.findById(userId);

		if (user.isPresent()) {
			return ResponseEntity.status(200).body(user.get());
		} else {
			return ResponseEntity.status(400).body(null);
		}
	}

	@PostMapping(value = "/user", consumes = { "application/xml", "application/json" }, produces = { "application/xml",
			"application/json" })
	public ResponseEntity<User> addUser(@RequestBody User user) {

		User savedUser = userRepo.save(user);

		return ResponseEntity.status(201).body(savedUser);

	}

	@PutMapping(value = "/user/{userId}", consumes = { "application/xml", "application/json" }, produces = {
			"application/xml", "application/json" })
	public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User user) {

		User u = userRepo.findById(userId).orElseThrow();

		u.setEmail(user.getEmail());
		u.setUname(user.getUname());
		u.setPhno(user.getPhno());

		User updatedUser = userRepo.save(u); // upsert

		return ResponseEntity.status(200).body(updatedUser);
	}

	@DeleteMapping(value = "/user/{userId}", produces = { "application/xml", "application/json" })
	public ResponseEntity<User> deleteUser(@PathVariable Integer userId) {

		Optional<User> user = userRepo.findById(userId);

		if (user.isPresent()) {
			userRepo.delete(user.get());
		} else {
			throw new NoUserFoundException("Invalid User ID : " + userId);
		}

		return ResponseEntity.status(200).body(user.get());
	}

}
