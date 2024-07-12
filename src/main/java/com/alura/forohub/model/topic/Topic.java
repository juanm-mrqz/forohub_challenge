package com.alura.forohub.model.topic;

import com.alura.forohub.model.course.Course;
import com.alura.forohub.model.response.Response;
import com.alura.forohub.model.users.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Topic")
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topic {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;

    private String message;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    //ManyToOne Relationship (in User)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="author_id")
    private User author;

    //ManyToOne relationship unidirectional (in Course)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private Course course;

    //OneToMany relationship
    @OneToMany(mappedBy="topic")
    private List<Response> responses = new ArrayList<>();


    public Topic(TopicRegisterData data) {
        this.title = data.title();
        this.message = data.message();
        this.createdAt=LocalDateTime.now();
        this.status = data.status();
    }

    public void updateTopic(TopicUpdateData data) {

        if (data.status() != null)
            this.status = data.status();
        if (data.response() != null) {
            this.responses.add(new Response().generateResponse(this, data.response()));
        }
    }


}
