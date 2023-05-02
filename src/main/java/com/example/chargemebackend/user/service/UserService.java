package com.example.chargemebackend.user.service;

import com.example.chargemebackend.user.model.User;
import com.example.chargemebackend.user.repository.UserRepository;
import com.example.chargemebackend.utils.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getEmployeeById(Long id) {
        User user = null;
        try {
            user = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User updateUser(Long id, User userDetail) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));

        user.setFirstName(userDetail.getFirstName());
        user.setLastName(userDetail.getLastName());
        user.setEmail(userDetail.getEmail());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public boolean deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

        userRepository.delete(user);
        return true;
    }
}
