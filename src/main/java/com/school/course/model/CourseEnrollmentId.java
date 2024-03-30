/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.school.course.model;

/**
 *
 * @author panha
 */
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CourseEnrollmentId implements Serializable {

    @Column(name = "course_id")
    private UUID courseId;

    @Column(name = "user_id")
    private UUID userId;

    public CourseEnrollmentId(UUID courseId, UUID userId) {
        this.courseId = courseId;
        this.userId = userId;
    }
}
