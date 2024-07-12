package com.alura.forohub.model.topic;

import java.time.LocalDateTime;

public record TopicListView(

        String title,
        String message,
        LocalDateTime createdAt,
        String status,

        String author,

        String course

) {
    //Constructor
    public TopicListView(Topic topic) {
        this(
                topic.getTitle(), topic.getMessage(),
                topic.getCreatedAt(), topic.getStatus().toString(),
                topic.getAuthor().getLogin(), topic.getCourse().getName()
        );
    }
}
