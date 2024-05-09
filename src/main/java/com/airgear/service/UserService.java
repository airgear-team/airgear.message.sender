package com.airgear.service;

import com.airgear.dto.UserGetResponse;

public interface UserService {

    UserGetResponse getUserByEmail(String email);

}