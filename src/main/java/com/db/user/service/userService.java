package com.db.user.service;

import com.db.user.dto.request.userCreateRequest;
import com.db.user.dto.request.userUpdateRequest;
import com.db.user.dto.response.UserResponse;
import com.db.user.entity.user;
import com.db.user.exception.AppException;
import com.db.user.exception.ErrorCode;
import com.db.user.repository.userRepository;
import com.db.user.mapper.UserMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class userService {
    userRepository userRepository;
    UserMapper userMapper;

    public user createUser(userCreateRequest request) {

        if(userRepository.existsByusername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXITAED);

        user User = userMapper.toUser(request);

        return userRepository.save(User);
    }
    public UserResponse updateUser(String userId, userUpdateRequest request) {
        user User = getUser(userId);

        userMapper.UpdateUser(User, request);

        return userMapper.toUserResponse( userRepository.save(User));

    }
    public List<user> getUser() {
        return userRepository.findAll();
    }
    public user getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOTFOUND));
    }
    public UserResponse getUserResponse(String userId) {
        return userMapper.toUserResponse( userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOTFOUND)));
    }
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
