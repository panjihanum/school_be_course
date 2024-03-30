/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.school.course.service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final MainService mainService;

    public String getTokenFrom(String bearerToken) {
        final String bearer = "Bearer ";
        if (bearerToken == null || !bearerToken.startsWith(bearer)) {
            throw new JWTVerificationException("Invalid Authorization Header");
        }
        String token = bearerToken.substring(bearer.length());
        return token;
    }

    public String getSubjectFrom(String token) {
        mainService.getUsers(token);
        return "";
    }
}
