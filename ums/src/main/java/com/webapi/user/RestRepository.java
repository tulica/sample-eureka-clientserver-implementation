package com.webapi.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webapi.user.model.UMS;

@Repository
public interface RestRepository extends CrudRepository<UMS,Long>{

}
