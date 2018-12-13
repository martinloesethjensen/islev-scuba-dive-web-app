package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.api;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Admin;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Course;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.controller.AdminController;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/courses")
public class CoursesAPI {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("list")
    public ResponseEntity list() { return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK); }

    @PostMapping("create")
    public ResponseEntity create(Course course) {
        if (course == null)
            return new ResponseEntity<>("Course not created", HttpStatus.NOT_IMPLEMENTED);
        AdminController.success = true;
        courseRepository.save(course);

        return new ResponseEntity<>(String.format("Course %s Created", course), HttpStatus.OK);
    }
}
