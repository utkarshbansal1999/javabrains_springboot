package com.example.javabrains_springboot.course;

import com.example.javabrains_springboot.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

//    List<Course> ratings= new ArrayList<>(Arrays.asList(
//            new Course("12","java","java"),
//            new Course("13","python","python")
//    ));

    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getAllCourses() {
        List<Course> courses=new ArrayList<>();
        courseRepo.findAll().forEach(courses::add);
        return courses;
        //return ratings;
    }

    public Optional<Course> getCourse(String courseid) {
        return courseRepo.findById(courseid);
        //return ratings.stream().filter(course -> course.getId().equals(courseid)).findFirst().get();
    }

    public void addCourse(Course course) {
        courseRepo.save(course);
        //ratings.add(course);
    }


    public void updateCourse(Course course, String courseid) {

        courseRepo.save(course);
//        for(int i=0;i<ratings.size();i++)
//        {
//            if(ratings.get(i).getId().equals(courseid))
//            {
//                ratings.set(i,course);
//                return ;
//            }
//        }
    }

    public void deleteCourse(String courseid) {
        courseRepo.deleteById(courseid);
        //ratings.removeIf(course -> course.getId().equals(courseid));
    }
}
