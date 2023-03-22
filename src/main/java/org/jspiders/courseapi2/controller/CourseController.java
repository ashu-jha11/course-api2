package org.jspiders.courseapi2.controller;

import org.jspiders.courseapi2.model.Course;
import org.jspiders.courseapi2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService service;


    @GetMapping("/")
    public String welcomeForm(Course c){
        return "welcome";
    }

    @GetMapping("/addcourse")
    public String displayCourseForm(Course c){
        return "addcourse";
    }

    @PostMapping("/insertcourse")
    public String addCourse(Course c){
        service.addCourse(c);
        return "courseinserted";
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return service.getAllCourses();
    }

    @GetMapping("/displaydetails")
    public String displayCourses(Model model){
        service.getAllCourses();
        model.addAttribute("courses",getAllCourses());
        return "displaydetails";
    }

    @GetMapping("/updatecourse")
    public String displayUpdateForm(Course c){
        return "updatecourse";
    }

    @PostMapping("/courseupdated")
    public String updateCourse(Course c){
        service.updateCourse(c);
        return "updated";
    }

    @GetMapping("/coursedelete")
    public String displaydeleteForm(Course c){
        return "coursedelete";
    }

    @PostMapping("/deletecourse")
    public String deleteCourse(Course c){
        service.deleteCourse(c);
        return "deleted";
    }
}
