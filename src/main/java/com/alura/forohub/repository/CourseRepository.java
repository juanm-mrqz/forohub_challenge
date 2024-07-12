package com.alura.forohub.repository;

import com.alura.forohub.model.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CourseRepository extends JpaRepository<Course, Long> {

}
