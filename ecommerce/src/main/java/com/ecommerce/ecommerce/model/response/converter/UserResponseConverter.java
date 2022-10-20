package com.ecommerce.ecommerce.model.response.converter;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.model.response.UserProductResponse;
import com.ecommerce.ecommerce.model.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Data
public class UserResponseConverter {

    private final UserProductResponseConverter userProductResponseConverter;

    public UserResponse fromUser(User user){
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getNumber(),
                user.getAreaCode(),
                user.getAge(),
                user.getEmail(),
                user.getIsActive(),
                user.getProducts()
                        .stream()
                        .map(userProductResponseConverter::convertToProductUser)
                        .collect(Collectors.toList()));
    }


}
