package com.alura.forohub.model.users;

import com.alura.forohub.model.profile.Profile;
import com.alura.forohub.model.topic.Topic;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="User")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_profiles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id", referencedColumnName = "id")
            )
    private List<Profile> profiles = new ArrayList<>();


    @OneToMany(mappedBy="author", fetch=FetchType.EAGER)
    List<Topic> topics = new ArrayList<>();




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profiles='" + profiles + '\'' +
                ", topics='" + topics + '\'' +
                '}';
    }
}
