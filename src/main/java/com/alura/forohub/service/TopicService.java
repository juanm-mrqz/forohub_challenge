package com.alura.forohub.service;

import com.alura.forohub.model.response.Response;
import com.alura.forohub.model.topic.*;
import com.alura.forohub.repository.CourseRepository;
import com.alura.forohub.repository.ResponseRepository;
import com.alura.forohub.repository.TopicRepository;
import com.alura.forohub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResponseRepository responseRepository;


    //Agregar topico
    public Topic saveTopic (TopicRegisterData data, String userLogin)  {
       var course = courseRepository.findById(data.courseId());

       Topic newTopic = new Topic(data);

       if (course.isPresent()) {
           newTopic.setCourse(course.get());
       }

       newTopic.setAuthor(userRepository.findByLoginOrEmail(userLogin, userLogin).get());

        return topicRepository.save(newTopic);
    }

    //Mostrar todos los topicos
    public List<TopicListView> showAll(){
        return topicRepository.findAll().stream()
            .map(TopicListView::new)
            .toList();
    }

    //Mostrar topico por id

    public Topic findTopicById(Long id) {
        return topicRepository.findById(id).get();
    }
    //Eliminar topico
    public Topic deleteTopic(Long id){
        var topic = topicRepository.getReferenceById(id);
        topicRepository.delete(topic);
        return topic;
    }

    //Mostrar topicos mas recientes
    public List<Topic> findByOrderByCreatedAtDesc(Limit limit) {
        return topicRepository.findByOrderByCreatedAtDesc(limit);
    }


    //Agregar respuesta a topico

    public TopicResponse addResponseToTopic(Topic topic, String author, String message) {

        //2. Obtener el usuario que hace la respuesta
        var user = userRepository.findByLoginOrEmail(author, author);

        //2. Crear un objeto de respuesta
        Response newResponse = new Response().generateResponse(topic, message);

        //3. Adherir la respuesta a un usuario
        newResponse.setUser(user.get());

        //4. Guardar la respuesta en el repositorio
        responseRepository.save(newResponse);

        return new TopicResponse(topic);

    }
    //Modificar estado del topico
    public TopicResponse updateStatus(Topic topicToUpdate, Status status){
        topicToUpdate.setStatus(status);
        topicRepository.save(topicToUpdate);
        return new TopicResponse(topicToUpdate);
    }

    public List<Topic> findByCourseContaining(String courseName){
        return topicRepository.findByCourseContaining(courseName);
    }

    public TopicResponse setAsSolution(Topic topicToUpdate, int positionOfSolution) {
        var responseLength = topicToUpdate.getResponses().size();

        if(responseLength < 1 || positionOfSolution > responseLength -1) {
            return new TopicResponse(topicToUpdate);
        }

        //En la request, el indice de las respuestas empieza en uno
        topicToUpdate.getResponses().get(positionOfSolution-1).setSolution(true);
        return new TopicResponse(topicRepository.save(topicToUpdate));
    }
}
