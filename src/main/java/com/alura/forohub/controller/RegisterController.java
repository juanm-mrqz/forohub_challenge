package com.alura.forohub.controller;

import com.alura.forohub.model.users.RegisterUserDto;
import com.alura.forohub.model.profile.Role;
import com.alura.forohub.model.users.User;
import com.alura.forohub.repository.ProfileRepository;
import com.alura.forohub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProfileRepository profileRepository;


    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto data) {

        if(userService.existsByLoginOrEmail(data.getEmail()) || userService.existsByLoginOrEmail(data.getUsername()))
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);

        // create user object
        User user = new User();
        user.setLogin(data.getUsername());
        user.setEmail(data.getEmail());
        user.setPassword(data.getPassword());
        user.setProfiles(List.of(profileRepository.findByName(Role.USER).get()));

        userService.saveUser(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
