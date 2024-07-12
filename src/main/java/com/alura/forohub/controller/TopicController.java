package com.alura.forohub.controller;


import com.alura.forohub.model.topic.*;
import com.alura.forohub.service.TopicService;
import com.alura.forohub.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/topics")
@SecurityRequirement(name = "bearer-key")
public class TopicController {



    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @GetMapping("/current_user")
    public ResponseEntity<String> getCurrentUserFromDB(Principal principal) {
        return ResponseEntity.ok(principal.getName());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicListView> registerTopic
            (@RequestBody @Valid TopicRegisterData data,
             UriComponentsBuilder uriComponentBuilder,
             Principal principal) {

        Topic topic = topicService.saveTopic(data, principal.getName());

        URI url = uriComponentBuilder.path("/topics/{id}")
                .buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(new TopicListView(topic));
    }

    @GetMapping
    public ResponseEntity<List<TopicListView>> getAllTopics() {
        return ResponseEntity.ok(topicService.showAll());

    }

    @GetMapping("/recents")
    public List<TopicListView> getRecentsTopics() {
        return topicService.findByOrderByCreatedAtDesc(Limit.of(2))
                .stream()
                .map(TopicListView::new)
                .toList();
    }

    @GetMapping("/search")
    public List<TopicResponse> getByCourse(@RequestParam String course) {
        return topicService
                .findByCourseContaining(course)
                .stream()
                .map(TopicResponse::new)
                .toList();
    }

//    @GetMapping("/search")
//    public List<TopicListData> getByYearPub(
//            @RequestParam(name="year", required = false) Integer year) {
//        return topicRepository.findByCreatedAtYear(year)
//                .stream()
//                .map(TopicListData::new)
//                .toList();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> getTopicDetails(@PathVariable Long id) {
        return ResponseEntity.ok(new TopicResponse(topicService.findTopicById(id)));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicResponse> updateTopic(@PathVariable Long id, @RequestBody @Valid TopicUpdateData data, Principal principal) {
        var topic = topicService.findTopicById(id);
        //Actualizar estado
        if (data.status() != null) {
            topicService.updateStatus(topic, data.status());
        }
        //Agregar una respuesta
        if(data.response() != null) {
            topicService.addResponseToTopic(topic, principal.getName(), data.response());
        }
        //Marcar respuesta como solucion
        if (data.solution() != null) {
            topicService.setAsSolution(topic, data.solution());
        }


        return ResponseEntity.ok(new TopicResponse(topic));
    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}
