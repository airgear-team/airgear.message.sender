package com.airgear.service;

import com.airgear.dto.UserGetResponse;

public interface UserService {

//    UserGetResponse create(UserSaveRequest request);

    UserGetResponse getUserByEmail(String email);

}