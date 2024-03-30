/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.school.course.controller;

import com.school.course.service.CourseService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author panha
 */
@RestController
@RequestMapping("/student/courses")
@RequiredArgsConstructor
public class CourseStudentController {

    private final CourseService courseService;

    @GetMapping()
    @RolesAllowed("STUDENT")
    public ResponseEntity<String> getStudentCourse() {
        return ResponseEntity.status(200).body(courseService.getCourses());
    }
}
