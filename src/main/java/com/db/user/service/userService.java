package com.db.user.service;

import com.db.user.dto.request.userCreateRequest;
import com.db.user.dto.request.userUpdateRequest;
import com.db.user.entity.user;
import com.db.user.exception.AppException;
import com.db.user.exception.ErrorCode;
import com.db.user.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    private userRepository userRepository;

    public user createUser(userCreateRequest request) {
        user User = new user();

        if(userRepository.existsByusername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXITAED);

        User.setUsername(request.getUsername());
        User.setPassword(request.getPassword());
        User.setFirstname(request.getFirstname());
        User.setLastname(request.getLastname());
        User.setDaybird(request.getDaybird());

        return userRepository.save(User);
    }
    public user updateUser(String userId, userUpdateRequest request) {
        user User = getUser(userId);

        User.setPassword(request.getPassword());
        User.setFirstname(request.getFirstname());
        User.setLastname(request.getLastname());
        User.setDaybird(request.getDaybird());

        return userRepository.save(User);

    }
    public List<user> getUser() {
        return userRepository.findAll();
    }
    public user getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOTFOUND));
    }
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
