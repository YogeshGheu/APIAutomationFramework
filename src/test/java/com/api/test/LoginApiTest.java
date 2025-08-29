package com.api.test;

import static io.restassured.RestAssured.*;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListeners.class)

public class LoginApiTest {

    @Test(description = "verify if login api is working")
    public void LoginTest() {
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("yogeshgheu01", "yogesh123");
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertEquals(loginResponse.getUsername(), "yogeshgheu01");

    }
}










