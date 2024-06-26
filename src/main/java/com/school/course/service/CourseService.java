/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.school.course.service;

import com.school.course.dao.CourseRepository;
import com.school.course.dto.CourseRequest;
import com.school.course.exception.ResourceNotFoundException;
import com.school.course.model.Course;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author panha
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AuthService authService;

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

    public Course updateCourse(UUID courseId, CourseRequest courseRequest) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (!optionalCourse.isPresent()) {
            throw new ResourceNotFoundException("Course not found with id ", courseId);
        }

        Course course = optionalCourse.get();
        course.setTeacherId(courseRequest.getTeacherId());
        course.setTitle(courseRequest.getTitle());
        course.setDescription(courseRequest.getDescription());
        course.setEffectiveDate(courseRequest.getEffectiveDate());
        course.setExpiryDate(courseRequest.getExpiryDate());

        return courseRepository.save(course);
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public List<Course> getStudentCourses() {
        return courseRepository.findByEnrollmentsIdUserIdAndIsActiveTrue(authService.getUserId());
    }

    public List<Course> getTeacherCourse() {
        return courseRepository.findByTeacherId(authService.getUserId());
    }
}
