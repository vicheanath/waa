package com.vicheanath.waa.service;

import com.vicheanath.waa.dto.request.LoginRequest;
import com.vicheanath.waa.dto.request.RefreshTokenRequest;
import com.vicheanath.waa.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}