package com.ryazanova.MyApplicationH2.service;

import com.ryazanova.MyApplicationH2.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> getAllCourses();
    Course getCourse(int id);
    Course saveCourse(Course course);
    void deleteCourse(int id);
}
