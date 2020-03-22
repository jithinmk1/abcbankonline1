package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
@RestController
public class UserRegistrationController {
    @Autowired
    UserRepository userRepository;

    public UserRegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getAllUserById(@PathVariable(value = "id") Integer id) {
        return userRepository.findById(id);
    }

    @PostMapping("/registration")
    public @Valid User CreateUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable(value = "id") Integer id, @Valid @RequestBody User user) throws UserNotFoundException {

        User u1 = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        u1.setFirst_name(user.getFirst_name());
        u1.setMiddle_name(user.getMiddle_name());
        u1.setLast_name(user.getLast_name());
        u1.setEmail(user.getEmail());
        u1.setMobile_number(user.getMobile_number());
        u1.setAddress(user.getAddress());
        u1.setPassword(user.getPassword());
        User updUser = userRepository.save(u1);
       return updUser;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int Id) throws UserNotFoundException {
        User u2 = userRepository.findById(Id)
                .orElseThrow(() -> new UserNotFoundException(Id));

        userRepository.delete(u2);
        return ResponseEntity.ok().build();
    }


}





