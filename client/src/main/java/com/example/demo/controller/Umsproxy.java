package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.UMS;

import feign.Response;
 

@FeignClient(name="UserManagementSystem")
public interface Umsproxy {


	@GetMapping("/users")
	List<UMS> retrieveAllUsers();

	@PostMapping("/users")
	ResponseEntity<Object> createUser(UMS user);
	
	@GetMapping(path="/users/{id}")
	UMS retrieveUser(@PathVariable long id);
	
	@PutMapping(path="/users/{id}")
	ResponseEntity<Object> updateUser(@RequestBody UMS user, @PathVariable long id);
	
	@DeleteMapping(path="/users/{id}")
	void deleteUser(@PathVariable long id);
	
}
