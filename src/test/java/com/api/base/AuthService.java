package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class AuthService extends BaseService{
    private final static String BASE_PATH = "/api/auth";
    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    public AuthService(){
        super();
    }

    public Response login(LoginRequest payload){
        return postRequest(BASE_PATH + "/login", payload);
    }

    public Response signup(SignupRequest payload) {
        return postRequest(BASE_PATH + "/signup", payload);
    }

    public Response forgotPassword(String emailAddress){
        Map<String, String> payload = new HashMap<>();
        payload.put("email", emailAddress);
        return postRequest(BASE_PATH + "/forgot-password", payload);
    }

    public String getToken(){
        LoginRequest loginRequest = new LoginRequest("yogeshgheu01", "yogesh123");
        Response loginResponseObj = login(loginRequest);
        LoginResponse loginResponse = loginResponseObj.as(LoginResponse.class);
        return loginResponse.getToken();
    }


}
