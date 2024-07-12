package com.alura.forohub.model.topic;

import com.alura.forohub.model.response.ResponseData;

import java.time.LocalDateTime;
import java.util.List;

public record TopicResponse(

        String title,
        String message,
        LocalDateTime createdAt,
        String status,

        String author,

        String course,
        List<ResponseData> responsesData

)
{
    //Constructor
    public TopicResponse(Topic topic) {
        this(
                topic.getTitle(), topic.getMessage(),
                topic.getCreatedAt(), topic.getStatus().toString(),
                topic.getAuthor().getLogin(), topic.getCourse().getName(),
                topic.getResponses().stream().map(ResponseData::new).toList()
        );
    }
}

