package com.init.users.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.users.entities.User;

@RestController
@RequestMapping("users")
public class UsersREST {

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<User>> getUser() {
		return null;
	}

}
