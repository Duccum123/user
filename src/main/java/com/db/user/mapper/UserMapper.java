package com.db.user.mapper;

import com.db.user.dto.request.userCreateRequest;
import com.db.user.dto.request.userUpdateRequest;
import com.db.user.dto.response.UserResponse;
import com.db.user.entity.user;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    user toUser(userCreateRequest request);
    // @Mapping(source = "username", target = "password") // ví dụ không trùng field
    // @Mapping(target = "username", ignore = true) // không map cho username
    UserResponse toUserResponse(user User);
    void UpdateUser(@MappingTarget user User, userUpdateRequest userUpdateRequest);
}
