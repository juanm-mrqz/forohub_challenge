package com.alura.forohub.model.response;

import com.alura.forohub.model.topic.Topic;
import com.alura.forohub.model.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name="Response")
@Table(name = "responses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Response {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String message;

    //OneToManyRelations
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="topic_id")
    private Topic topic;

    //OneToMany unidirectional Relationship
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User user;

    private LocalDateTime createdAt;

    private Boolean solution;


    public Response generateResponse(Topic topic, String message) {
        var response = new Response();
        response.setTopic(topic);
        response.setMessage(message);
        response.setCreatedAt( LocalDateTime.now());
        response.setSolution(false);
        return response;
    }

}
