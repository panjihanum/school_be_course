/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.school.course.dao;

/**
 *
 * @author panha
 */
import com.school.course.model.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query("SELECT c FROM Course c JOIN c.enrollments e WHERE e.id.userId = :userId AND e.isActive = true")
    List<Course> findByEnrollmentsIdUserIdAndIsActiveTrue(UUID userId);

    List<Course> findByTeacherId(UUID teacherId);
}
