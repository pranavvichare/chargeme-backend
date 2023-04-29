package com.example.chargemebackend.user.controller;

import com.example.chargemebackend.user.model.User;
import com.example.chargemebackend.user.service.UserService;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = null;
        user = userService.getEmployeeById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable Long id, @RequestBody User userDetails) {
        User user = null;
        user = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/users")
    public List<User> getAllEmployees(){
        return userService.getAllUsers();
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Map<String, Boolean> response = null;
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
