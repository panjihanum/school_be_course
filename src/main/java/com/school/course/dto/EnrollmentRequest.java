package com.school.course.dto;

import com.school.course.validation.NotBlankUUID;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollmentRequest {

    @NotBlankUUID(message = "Course must not be blank")
    private UUID courseId;

    @NotEmpty(message = "Student list must not be empty")
    private List<UUID> studentIds;
}
