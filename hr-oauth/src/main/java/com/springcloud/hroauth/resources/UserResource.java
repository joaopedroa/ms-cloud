package com.springcloud.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.hroauth.entities.User;
import com.springcloud.hroauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findUserByEmail(@RequestParam String email){
		try {
			User user = service.findByEmail(email);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
	}

}
