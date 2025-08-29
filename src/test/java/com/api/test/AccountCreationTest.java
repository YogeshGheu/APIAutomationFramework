package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "test sign up functionality")
    public void createAccountTest(){
        SignupRequest signupRequest = new SignupRequest.Builder()
                .userName("yogeshgheu01")
                .password("hello123")
                .email("yogeshgheu55062@gmail.com")
                .mobileNumber("8778986787")
                .firstName("yogesh")
                .lastName("gheu")
                .build();


        AuthService authService = new AuthService();
        Response response = authService.signup(signupRequest);
        response.then().log().all();
    }
}
