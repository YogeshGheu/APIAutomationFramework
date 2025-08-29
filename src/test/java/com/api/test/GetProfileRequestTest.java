package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProfileRequestTest {
    @Test
    public void getProfileInfoTest(){
        LoginRequest loginRequest = new LoginRequest("yogeshgheu01", "yogesh123");
        AuthService authService = new AuthService();
        Response loginResponseObj = authService.login(loginRequest);
        LoginResponse loginResponse = loginResponseObj.as(LoginResponse.class);
        String token = loginResponse.getToken();

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        Response profileResponse = userProfileManagementService.getProfile("/profile", token);
        UserProfileResponse userProfileResponse = profileResponse.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getId(), 2525);
        Assert.assertEquals(userProfileResponse.getUsername(), "yogeshgheu01");

        System.out.println(userProfileResponse);

    }

}
