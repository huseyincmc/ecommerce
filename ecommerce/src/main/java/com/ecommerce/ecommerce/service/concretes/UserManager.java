package com.ecommerce.ecommerce.service.concretes;

import com.ecommerce.ecommerce.exception.UserIsNotFoundException;
import com.ecommerce.ecommerce.exception.UserNotFoundException;
import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.model.request.UserRequest;
import com.ecommerce.ecommerce.model.response.UserResponse;
import com.ecommerce.ecommerce.model.response.converter.UserResponseConverter;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.ecommerce.ecommerce.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserResponseConverter userResponseConverter;

    @Override
    public UserResponse addUser(UserRequest userRequest) {

        User user = userRepository.save(User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .number(userRequest.getNumber())
                .areaCode(userRequest.getAreaCode())
                .age(userRequest.getAge())
                .email(userRequest.getEmail())
                .isActive(true).build());
        return userResponseConverter.fromUser(user);
    }
    @Override
    public UserResponse updateUser(String id, UserRequest userRequest) {
        User user= findById(id);
        if(!user.getIsActive()){
            log.warn("The user wanted update is not active! {}",id);
            throw new UserIsNotFoundException();
        }
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setAge(userRequest.getAge());
        user.setEmail(userRequest.getEmail());
        User updatedUser=userRepository.save(user);
        return userResponseConverter.fromUser(updatedUser);
    }
    @Override
    public void deleteUser(String id) {
         userRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userResponseConverter::fromUser).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUser(String id) {
        User user = findById(id);
        return userResponseConverter.fromUser(user);
    }

    @Override
    public void activeUser(String id) {
    changeActiveUser(id,true);
    }

    @Override
    public void deactiveUser(String id) {
        changeActiveUser(id,false);
    }
    private void changeActiveUser(String id,Boolean isActive){
        User user = findById(id);
        User updatedUser = new User(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getNumber(),
                user.getAreaCode(),
                user.getAge(),
                user.getEmail(),
                isActive);
        userRepository.save(updatedUser);

    }

    protected User findById(String id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User couldn't be found by following id:" + id));

    }
}
