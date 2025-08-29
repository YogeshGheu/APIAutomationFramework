package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilters;
import com.api.models.request.LoginRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    static {
        filters(new LoggingFilters());
    }

    private static final String BASE_URL = "https://swift.techwithjatin.com";
    private RequestSpecification requestSpecification;

    public  BaseService(){
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected Response postRequest(String endpoint, Object payload){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected void setToken(String token){
        requestSpecification.header("Authorization", "Bearer " + token);
    }

    protected Response getRequest(String endpoint){
        return requestSpecification.get(endpoint);
    }

    protected  Response putRequest(String endpoint, Object payload){
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }
}
