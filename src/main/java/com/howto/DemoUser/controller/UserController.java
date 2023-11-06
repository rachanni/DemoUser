package com.howto.DemoUser.controller;

import com.howto.DemoUser.entity.User;
import com.howto.DemoUser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public List<User> findAllUsers() {

        return (List<User>) userRepository.findAll();

    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Entity.User> findUserById(@PathVariable(value = "id") long id) {
//        Optional<Entity.User> user = userRepository.findById(id);
//
//        if (user.isPresent()) {
//            return ResponseEntity.ok().body(user.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
