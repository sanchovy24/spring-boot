package com.ryazanova.MyApplicationH2.dao;

import com.ryazanova.MyApplicationH2.entity.Course;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseDAO {
    List<Course> getAllCourses();
    Course saveCourse(Course course);
    Course getCourse(int id);
    void deleteCourse(int id);
}
