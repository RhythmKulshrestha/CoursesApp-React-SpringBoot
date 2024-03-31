package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MyController {

    //lets define interface type variable for CourseService.java
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "This is homepage.";
    }

    //get the list of courses.
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses(); //this will return courses from interface CourseService.java but there is no direct implementatin provided, so it go into child class body CourseServiceImpl.java and find getCourses() method.
    }

    //creating method that will return single course
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){ //to receive value we will @PathVariable so dynamic of courseId will go to String courseId.
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //method to create new course [Post]
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }

    //update the course [PUT method]
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course); //we are passing course from Course course which we are getting from the body.
    }

    //delete the course, here we have add Http status also and it is recommended.
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //if exception occurs then entity will be created giving status code 500
        }
    }
}
