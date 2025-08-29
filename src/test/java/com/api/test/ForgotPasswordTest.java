package com.api.test;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test
    public void testForgotPassword(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("yogeshgheu55062@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
