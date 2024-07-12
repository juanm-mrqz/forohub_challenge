package com.alura.forohub.service;

import com.alura.forohub.model.users.User;
import com.alura.forohub.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /*
     * DATABASE AUTHENTICATION
     * DaoAuthenticationProvider utiliza UserDetailsService para obtener username, pass
     * y otros atributos para autenticar al usuario.
     * */
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        //Buscar en db al usuario
         User user = userRepository.findByLoginOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        //Setear las autoridades del usuario definido
        Set<GrantedAuthority> authorities = user.getProfiles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName().toString()))
                .collect(Collectors.toSet());
        System.out.println(authorities);

        //Devolver un objeto userdetails.User con las credenciales
        return new org.springframework.security.core.userdetails.User(
                usernameOrEmail,
                user.getPassword(),
                authorities
        );
    }
}