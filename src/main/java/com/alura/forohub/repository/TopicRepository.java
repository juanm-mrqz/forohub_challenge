package com.alura.forohub.repository;

import com.alura.forohub.model.topic.Topic;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByOrderByCreatedAtDesc(Limit limit);

    @Query(value= """
            SELECT t FROM Topic t
            WHERE t.course in (SELECT c FROM Course c WHERE c.name LIKE %?1%)""")
    List<Topic> findByCourseContaining(String courseName);

    @Query(value="SELECT * FROM topics WHERE YEAR(created_at)=?1",
            nativeQuery = true
    )
    List<Topic> findByCreatedAtYear(Integer year);



}
