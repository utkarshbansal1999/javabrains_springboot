package com.example.javabrains_springboot.course;

import com.example.javabrains_springboot.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

//    List<Course> ratings= new ArrayList<>(Arrays.asList(
//            new Course("12","java","java"),
//            new Course("13","python","python")
//    ));

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return courseService.getAllCourses();
        //return ratings;
    }

    @GetMapping("/courses/{courseid}")
    public Optional<Course> getCourses(@PathVariable(value = "courseid") String courseid)
    {
        return courseService.getCourse(courseid);
        //return ratings.stream().filter(course -> course.getId().equals(courseid)).findFirst().get();
    }

    @RequestMapping(method = RequestMethod.POST,value="/courses")
    public void addCourse(@RequestBody Course course)
    {
        courseService.addCourse(course);
        //ratings.add(course);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/courses/{courseid}")
    public void updateCourse(@RequestBody Course course, @PathVariable(value = "courseid") String courseid)
    {
        courseService.updateCourse(course,courseid);
//        for(int i=0;i<ratings.size();i++)
//        {
//            if(ratings.get(i).getId().equals(courseid))
//            {
//                ratings.set(i,course);
//                return ;
//            }
//        }
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/courses/{courseid}")
    public void deleteCourse(@PathVariable(value = "courseid") String courseid)
    {
        courseService.deleteCourse(courseid);
        //ratings.removeIf(course -> course.getId().equals(courseid));
    }
}
