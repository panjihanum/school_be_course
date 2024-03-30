/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.school.course.service;

import com.school.course.model.CourseEnrollment;
import com.school.course.model.CourseEnrollmentId;
import com.school.course.dao.CourseEnrollmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private CourseEnrollmentRepository enrollmentRepository;

    public void enrollStudents(UUID courseId, Set<UUID> studentIds) {
        List<CourseEnrollment> existingEnrollments = enrollmentRepository.findByIdCourseId(courseId);
        existingEnrollments.forEach(enrollment -> enrollment.setActive(false));
        enrollmentRepository.saveAll(existingEnrollments);

        List<CourseEnrollment> enrollmentsToUpdate = enrollmentRepository.findByIdCourseIdAndIdUserIdIn(courseId, studentIds);
        enrollmentsToUpdate.forEach(enrollment -> enrollment.setActive(true));
        enrollmentRepository.saveAll(enrollmentsToUpdate);

        Set<UUID> existingStudentIds = enrollmentsToUpdate.stream().map(enrollment -> enrollment.getId().getUserId()).collect(Collectors.toSet());
        studentIds.removeAll(existingStudentIds);
        List<CourseEnrollment> newEnrollments = studentIds.stream()
                .map(studentId -> {
                    CourseEnrollment enrollment = new CourseEnrollment();
                    enrollment.setId(new CourseEnrollmentId(courseId, studentId));
                    enrollment.setActive(true);
                    return enrollment;
                })
                .collect(Collectors.toList());
        enrollmentRepository.saveAll(newEnrollments);
    }
}
