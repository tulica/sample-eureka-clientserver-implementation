package com.webapi.user;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.webapi.user.exception.UserNotFoundException;
import com.webapi.user.model.*;

public interface serviceinterface {
   public abstract ResponseEntity<Object> createUser(UMS user);
   public abstract void deleteUser(long id) throws UserNotFoundException;
   public abstract UMS getUser(long id) throws UserNotFoundException;
   public abstract ResponseEntity<Object> updateUser(UMS user, long id);
}


