package com.springrest.springrest.services;



import org.springframework.beans.factory.annotation.Autowired;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired //it will automatically object and it will inject the dependencies
    private CourseDao courseDao;

    //so lets make a list, so that we can store data temporarily. If you store data permanently then you have bring data back from database.
    List<Course> list = new ArrayList<>();

    //lets make constructor of List.
//    public CourseServiceImpl() { //As soon as object of CourseServiceImpl() is created
//
//        list.add(new Course(101, "Core Java", "This course contains basics of java"));
//        list.add(new Course(102, "Python", "Learn Python..."));
//        list.add(new Course(103,"MEAN stack", "learn mean stack here..."));
//    }

    //here we are going to return list of courses.
    @Override
    public List<Course> getCourses() {
    	
//    	return list;
        return courseDao.findAll(); //findAll will return all list of courses. It will get data from the database then it will create object and finally it return to us.
    
    }

    //list the course
    @Override
    public Course getCourse(Long courseId) {
        return courseDao.getReferenceById(courseId); //get single course
    }

    //add the course
    @Override
    public Course addCourse(Course course) {
        courseDao.save(course); //it will save course to the database.
        return course;
    }
 
    //update course
    @Override
    public Course updateCourse(Course course) {
        courseDao.save(course); //it will first it is already available in database, if available then update it.
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        //To delete, it first needs to load the entity from courseDao
        Course entity = courseDao.getReferenceById(parseLong); //we will get one entity and this same entity we will return.
        courseDao.delete(entity); //so it will only those entity which is passed from the body.
    }
}