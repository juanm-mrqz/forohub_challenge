package com.alura.forohub.model.topic;

public record TopicUpdateData(
        Status status,
        String response,
        //Si tiene respuestas, indica a cual quiero setear que sea una solucion
        Integer solution

) {
}
