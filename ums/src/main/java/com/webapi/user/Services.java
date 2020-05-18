package com.webapi.user;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webapi.user.exception.UserNotFoundException;
import com.webapi.user.model.UMS;

@Service
public class Services implements serviceinterface{

	@Autowired
	private RestRepository restRepository;
	
	@Override	
	public ResponseEntity <Object> createUser(@RequestBody UMS user) {
		UMS savedUser = restRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
				
		return ResponseEntity.created(location).build();
	}
	
	@Override
	public UMS getUser(@PathVariable long id) throws UserNotFoundException{
		UMS user = restRepository.findById(id).orElse(null);

		if (user==null)
			{System.out.println("in GEt function");
			throw new UserNotFoundException("This ID number does not exist-" + id);
         }
		return user;
	}
	
	@Override
	public ResponseEntity<Object> updateUser(UMS user, long id) {
		java.util.Optional<UMS> userOptional = restRepository.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);
		
		restRepository.save(user);

		return ResponseEntity.noContent().build();
	}
	
	@Override
	public void deleteUser(long id) throws UserNotFoundException{
				
		UMS user = restRepository.findById(id).orElse(null);
		if (user==null)
			throw new UserNotFoundException("id-" + id);
		restRepository.deleteById(id);
         System.out.println(user);
	}
		
}
