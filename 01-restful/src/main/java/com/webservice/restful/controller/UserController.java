package com.webservice.restful.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.webservice.restful.dao.UserDao;
import com.webservice.restful.exception.UserNotFoundException;
import com.webservice.restful.entities.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }


    //link to -> http://localhost:8080/api/v1/users
    //EntityModel
    //WebMvcLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id) {
        //return Optional.ofNullable(userDao.findOne(id));
        /* Inicio UserNotFoundException */
        User user = userDao.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id: " + id);
        /* Fin UserNotFoundException */

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;

    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userDao.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
        //userDao.save(user);
        //return ResponseEntity.created(null).build();
        /* Inicio Location - Response Headers */
        User savedUser = userDao.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
        /* Fin Location - Response Headers */
    }

}
