/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.school.course.controller;

import com.school.course.dto.CourseRequest;
import com.school.course.dto.EnrollmentRequest;
import com.school.course.model.Course;
import com.school.course.service.CourseService;
import com.school.course.service.EnrollmentService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import java.util.HashSet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author panha
 */
@RestController
@RequestMapping("/admin/courses")
@RequiredArgsConstructor
public class CourseAdminController {

    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    @PostMapping("/add")
    @RolesAllowed("ADMIN")
    public ResponseEntity<Course> addCourses(@RequestBody @Valid CourseRequest request) {
        Course course = courseService.addCourse(request);
        return ResponseEntity.status(HttpStatus.OK).body(course);
    }

    @PostMapping("/enrollment")
    @RolesAllowed("ADMIN")
    public ResponseEntity<String> enrollments(@RequestBody @Valid EnrollmentRequest request) {
        enrollmentService.enrollStudents(request.getCourseId(), new HashSet<>(request.getStudentIds()));
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
}