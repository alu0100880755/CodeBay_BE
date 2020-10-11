package com.init.users.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.users.dao.UsersDAO;
import com.init.users.entities.User;

@RestController
@RequestMapping("users")
public class UsersREST {

	@Autowired
	private UsersDAO userDAO;

	////////////////////
	// GET SECTION //
	///////////////////

	// Get Full Users List
	@GetMapping
	public ResponseEntity<List<User>> getUser() {

		List<User> users = userDAO.findAll();

		return ResponseEntity.ok(users);
	}

	// Get specific User By ID
	@RequestMapping(value = "{userID}")
	public ResponseEntity<User> getUserById(@PathVariable("userID") Long userID) {

		Optional<User> optionalUser = userDAO.findById(userID);

		if (optionalUser.isPresent()) {

			return ResponseEntity.ok(optionalUser.get());

		} else {

			return ResponseEntity.noContent().build();
		}

	}

	// Get active Users
	@RequestMapping("active_users")
	public ResponseEntity<List<User>> getActiveUser() {

		User user = new User();
		user.setActive(true);
		Example<User> example = Example.of(user);

		List<User> activeUsers = userDAO.findAll(example);

		if (activeUsers.isEmpty()) {

			return ResponseEntity.noContent().build();

		} else {

			return ResponseEntity.ok(activeUsers);

		}

	}

	// Get Users who live in X
	@RequestMapping(value = "/city/{city}")
	public ResponseEntity<List<User>> getUserbyCity(@PathVariable("city") String city) {

		List<User> activeUsers = userDAO.findByCityStartingWith(city);

		if (activeUsers.isEmpty()) {

			return ResponseEntity.noContent().build();

		} else {

			return ResponseEntity.ok(activeUsers);

		}

	}

	// Get cities starting per X
	@RequestMapping(value = "/city_name/{city}")
	public ResponseEntity<List<String>> getCities(@PathVariable("city") String city) {

		List<String> userCities = userDAO.findAllCitiesByLetter(city);

		if (userCities.isEmpty()) {

			return ResponseEntity.notFound().build();

		} else {

			return ResponseEntity.ok(userCities);

		}

	}

	// Get Users by creation date (ASC/DESC)
	@RequestMapping(value = "/date/{order}")
	public ResponseEntity<List<User>> getUserbyDate(@PathVariable("order") String order) {

		List<User> orderUsers = null;

		switch (order) {

		case "asc": {
			orderUsers = userDAO.findByOrderByCreationdateAsc();
			break;
		}

		case "desc": {
			orderUsers = userDAO.findByOrderByCreationdateDesc();
			break;
		}
		}

		if (orderUsers.isEmpty()) {

			return ResponseEntity.noContent().build();

		} else {

			return ResponseEntity.ok(orderUsers);

		}

	}

	////////////////////////////
	// POST SECTION (CREATE) //
	////////////////////////////

	// Create a user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User newUser = userDAO.save(user);

		return ResponseEntity.ok(newUser);

	}

	///////////////////////////
	// PUT SECTION (UPDATE) //
	///////////////////////////

	// Update user
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {

		Optional<User> optionalUser = userDAO.findById(user.getId());

		if (optionalUser.isPresent()) {

			// Updated data
			User updatedUser = optionalUser.get();

			// Updating values
			updatedUser.setName(user.getName());
			updatedUser.setSurname(user.getSurname());
			updatedUser.setEmail(user.getEmail());
			updatedUser.setCity(user.getCity());
			updatedUser.setActive(user.getActive());
			updatedUser.setBirthday(user.getBirthday());

			// Updating user
			userDAO.save(updatedUser);

			return ResponseEntity.ok(updatedUser);

		} else {

			return ResponseEntity.notFound().build();

		}

	}

	//////////////////////
	// DELETE SECTION //
	/////////////////////

	// Delete user by URL
	@DeleteMapping(value = "{userID}")
	public ResponseEntity<String> deleteUserByURL(@PathVariable("userID") Long userID) {

		userDAO.deleteById(userID);

		return ResponseEntity.ok("User deleted");

	}

	// Delete user by ID
	@DeleteMapping
	public ResponseEntity<String> deleteUserById(@RequestBody User user) {

		userDAO.deleteById(user.getId());

		return ResponseEntity.ok("User deleted");

	}

	// Delete all users
	@DeleteMapping(value = "/deleteallusers")
	public ResponseEntity<String> deleteAllUsers() {

		userDAO.deleteAll();

		return ResponseEntity.ok("All users deleted");

	}

}
