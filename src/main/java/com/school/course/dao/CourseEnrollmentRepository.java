/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.school.course.dao;

import com.school.course.model.CourseEnrollment;
import com.school.course.model.CourseEnrollmentId;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, CourseEnrollmentId> {

    List<CourseEnrollment> findByIdCourseId(UUID courseId);

    List<CourseEnrollment> findByIdUserId(UUID userId);

    List<CourseEnrollment> findByIdCourseIdAndIdUserIdIn(UUID courseId, Set<UUID> userIds);
}
