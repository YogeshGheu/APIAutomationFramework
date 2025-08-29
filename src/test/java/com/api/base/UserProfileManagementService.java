package com.api.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService{

    private static final String BASE_PATH = "/api/users";

    public Response getProfile(String endpoint, String token){
        setToken(token);
        return getRequest(BASE_PATH + endpoint);
    }

    public Response updateProfile(String endpoint, String token, Object payload){
        setToken(token);
        return putRequest(BASE_PATH + endpoint, payload);
    }



}
