/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.school.course.service;

import com.school.course.dao.CourseRepository;
import com.school.course.dto.CourseRequest;
import com.school.course.model.Course;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author panha
 */
@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(CourseRequest courseRequest) {
        Course course = new Course();
        course.setTeacherId(courseRequest.getTeacherId());
        course.setTitle(courseRequest.getTitle());
        course.setDescription(courseRequest.getDescription());
        course.setEffectiveDate(courseRequest.getEffectiveDate());
        course.setExpiryDate(courseRequest.getExpiryDate());

        courseRepository.save(course);

        return course;
    }

    public String getCourses() {
        return this.getUserId().toString();
    }

    public UUID getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            UUID userId = (UUID) authentication.getPrincipal();
            return userId;
        } else {
            return null;
        }
    }
}
