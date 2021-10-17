package com.adobe.project.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

	public boolean isAuthorized(Long token, String role) {
		return true;
	}
}
