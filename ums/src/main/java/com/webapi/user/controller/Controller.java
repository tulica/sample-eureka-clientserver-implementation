package com.webapi.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webapi.user.RestRepository;
import com.webapi.user.Services;
import com.webapi.user.exception.UserNotFoundException;
import com.webapi.user.model.UMS;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@CrossOrigin
@RestController
@RequestMapping()

public class Controller {
	
	@Autowired
	private RestRepository restRepository;
	@Autowired
	Services service;
	
	@GetMapping("/users")
	public List<UMS> retrieveAllUsers() {
		return (List<UMS>)restRepository.findAll();
	}
	
	@PostMapping("/users")
	public ResponseEntity <Object> createUser(@RequestBody UMS user) {
		ResponseEntity<Object> newuser=this.service.createUser(user);
	      return newuser;
	      }
	
	@GetMapping("/users/{id}")
	public UMS retrieveUser(@PathVariable long id) throws UserNotFoundException{
		UMS user = service.getUser(id);	
		return user;
	}
	
	@PutMapping("users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody UMS user, @PathVariable long id) {	
		service.updateUser(user, id);
		return new ResponseEntity<>("User Data successfully updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable long id) throws UserNotFoundException{
		service.deleteUser(id);
	}

	
}
	
	
	


