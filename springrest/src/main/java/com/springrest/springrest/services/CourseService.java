package com.springrest.springrest.services;


import java.util.List;

import com.springrest.springrest.entities.Course;

public interface CourseService {

    //method that will return list of courses.
     List<Course> getCourses();

     //getting single course
    Course getCourse(Long courseId);

    //add course
    public Course addCourse(Course course);

    //updating course
    Course updateCourse(Course course);

    //delete the course
    void deleteCourse(long parseLong);
}
