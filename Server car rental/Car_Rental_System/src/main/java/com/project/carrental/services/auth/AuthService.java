package com.project.carrental.services.auth;


import com.project.carrental.dto.SignupRequest;
import com.project.carrental.dto.UserDto;

public interface AuthService {

     UserDto createUser(SignupRequest signupRequest) throws Exception;

     Boolean hasUserWithEmail(String email);

}
