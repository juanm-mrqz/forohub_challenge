package com.alura.forohub.repository;

import com.alura.forohub.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String username);

    Optional<User> findByLoginOrEmail(String login, String orEmail);
    Boolean existsByLogin(String username);
    Boolean existsByEmail(String email);
}
