package com.ecommerce.ecommerce.service.abstracts;

import com.ecommerce.ecommerce.model.request.UserRequest;
import com.ecommerce.ecommerce.model.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse addUser(UserRequest userRequest);

    UserResponse updateUser(String id, UserRequest userRequest);

    void deleteUser(String id);

    List<UserResponse> getAllUsers();

    UserResponse getUser(String id);

    void activeUser(String id);

    void deactiveUser(String id);


}
