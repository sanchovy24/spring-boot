package com.ryazanova.MyApplicationH2.controller;

import com.ryazanova.MyApplicationH2.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ryazanova.MyApplicationH2.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class



CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("courses/{id}")
    public Course getCourse(@PathVariable("id") int id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
       courseService.saveCourse(course);
        return course;
    }

    @DeleteMapping("courses/{id}")
    public void deleteCourse(@PathVariable("id") int id) {
        courseService.deleteCourse(id);
    }
}
