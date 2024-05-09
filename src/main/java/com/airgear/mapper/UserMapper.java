package com.airgear.mapper;

import com.airgear.dto.UserGetResponse;
import com.airgear.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserGetResponse toDto(User user);

    User toModel(UserGetResponse dto);

    List<UserGetResponse> toDtoList(List<User> users);

    List<User> toModelList(List<UserGetResponse> dtos);
}
