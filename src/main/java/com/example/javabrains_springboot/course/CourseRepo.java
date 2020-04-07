package com.example.javabrains_springboot.course;

import com.example.javabrains_springboot.topic.Topic;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepo extends CrudRepository<Course,String>{

}
