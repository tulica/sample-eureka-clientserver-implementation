package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UMS;



@RestController
@RequestMapping("")
public class UserController {

	@Autowired
	private Umsproxy proxy;
	
	@GetMapping("/users")
	public List<UMS> RetrieveAllUsers() {
		List<UMS> user = proxy.retrieveAllUsers();
		return user;
	}
	

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody UMS user) {
		 
	      return proxy.createUser(user);
	}
	
	@GetMapping("/users/{id}")
	public UMS retrieveUser(@PathVariable long id) {
		UMS user = proxy.retrieveUser(id);	
		return user;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody UMS user, @PathVariable long id) {	
		proxy.updateUser(user, id);
		return new ResponseEntity<>("User Data successfully updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable long id){
		proxy.deleteUser(id);
	}
}
