package com.project.carrental.dto;

import com.project.carrental.enums.UserRole;
import lombok.Data;


public class AuthenticationResponse {

    private String jwt;

    private UserRole userRole;

    private Long userId;

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}


    
}
