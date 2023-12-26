package com.webservice.restful.repositories;

import com.webservice.restful.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {



}
