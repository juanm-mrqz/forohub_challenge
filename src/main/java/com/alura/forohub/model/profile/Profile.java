package com.alura.forohub.model.profile;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Profile")
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Profile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role name;

    public Profile(Role name) { this.name = name; }
}


