package com.healthedge.sso.service;

import com.healthedge.sso.dto.LoginRequest;
import com.healthedge.sso.dto.LoginResponse;
import org.springframework.stereotype.Service;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}
