package com.alura.forohub.model.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRegisterData(
    @NotBlank(message="required title")
    String title,
    @NotBlank(message="required message")
    String message,
    @NotNull(message="course required")
    Long courseId,
    Status status

) {
}
