/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.school.course.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author panha
 */
@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    @GetMapping("/")
    public ResponseEntity<String> getUsers(Authentication authentication) {
        return ResponseEntity.status(200).body((String) authentication.getPrincipal());
    }
}
