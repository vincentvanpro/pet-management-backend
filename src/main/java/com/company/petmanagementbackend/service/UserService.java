package com.company.petmanagementbackend.service;

import com.company.petmanagementbackend.exception.UserNotFoundException;
import com.company.petmanagementbackend.model.User;
import com.company.petmanagementbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(User user) {
        Optional<User> existingUserOptional = userRepository.findUserByUsername(user.getUsername());
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            if(existingUser.getUsername().equals(user.getUsername()) &&
                    existingUser.getPassword().equals(user.getPassword())) {
                existingUser.setPassword("");
                return existingUser;
            }
        }

        throw new UserNotFoundException(
                String.format("%s", "User with this credentials was not found")
        );

    }
}
