package com.alura.forohub.service;

import com.alura.forohub.model.users.User;
import com.alura.forohub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Optional<User> findByLoginOrEmail(String login) {
        return userRepository.findByLoginOrEmail(login, login);
    }

    public boolean existsByLoginOrEmail(String login) {
        return userRepository.existsByEmail(login) || userRepository.existsByLogin(login);
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


}