package com.example.cp3566project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping (path = "/course")
public class CourseController {
    @Autowired

    private CourseRepository courseRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewCourse(@RequestParam String courseName, @RequestParam String courseNumber
            , @RequestParam Integer capacity) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseNumber(courseNumber);
        course.setCapacity(capacity);
        courseRepository.save(course);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Course> getAllCourse() {
        return courseRepository.findAll();
    }
    
    @GetMapping(path = "/view/{courseId}")
    public @ResponseBody Optional<Course> getCourse(@PathVariable("courseId") Integer courseId) {
        return courseRepository.findById(courseId);
    }
}
