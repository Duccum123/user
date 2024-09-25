package com.db.user.controller;

import com.db.user.dto.request.ApiResponse;
import com.db.user.dto.request.userCreateRequest;
import com.db.user.dto.request.userUpdateRequest;
import com.db.user.dto.response.UserResponse;
import com.db.user.entity.user;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.db.user.service.userService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class userController {
    userService userService;

    @PostMapping
    ApiResponse<user> createUser(@RequestBody userCreateRequest request) {
        ApiResponse<user> apiResponse = new ApiResponse<user>();
        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @GetMapping
    List<user> getUser() {
        return userService.getUser();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String userId) {
        return userService.getUserResponse(userId);
    }
    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId, @RequestBody userUpdateRequest request) {
        return userService.updateUser(userId, request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
         userService.deleteUser(userId);
         return "User has been deleted";
    }
}
