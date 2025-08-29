package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.UpdateProfileRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UpdateProfileTest {
    @Test
    public void testUpdateProfile(){
        AuthService authService = new AuthService();
        String token = authService.getToken();

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();

        UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest.Builder()
                .email("yogeshgheu55062@gmail.com")
                .firstName("yogesh")
                .lastName("gheu")
                .mobileNumber("9898989898")
                .id(2525)
                .username("yogeshgheu01")
                .build();

        Response response = userProfileManagementService.updateProfile("/profile", token, updateProfileRequest);

        System.out.println(response.asPrettyString());
    }
}
