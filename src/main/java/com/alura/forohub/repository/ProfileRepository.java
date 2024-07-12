package com.alura.forohub.repository;

import com.alura.forohub.model.profile.Profile;
import com.alura.forohub.model.profile.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByName(Role name);
}
