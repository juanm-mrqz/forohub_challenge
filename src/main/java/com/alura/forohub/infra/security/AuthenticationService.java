package com.alura.forohub.infra.security;

import com.alura.forohub.model.users.LoginDto;
import com.alura.forohub.model.users.RegisterUserDto;
import com.alura.forohub.model.profile.Profile;
import com.alura.forohub.model.profile.Role;
import com.alura.forohub.model.users.User;
import com.alura.forohub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenService jwtTokenService;



    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenService.generateToken(authentication);

        return token;
    }

    public User signUp (RegisterUserDto userRegisterData) {
        User user = new User();
        user.setLogin(userRegisterData.getUsername());
        user.setEmail(userRegisterData.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterData.getPassword()));
        user.setProfiles(List.of(new Profile(Role.ADMIN)));
        return userRepository.save(user);
    }

}
