package com.ecommerce.ecommerce.model.response.converter;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.model.response.ProductUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component



public class ProductUserResponseConverter {

    public ProductUserResponse convertToUserProduct(User user){

        return new ProductUserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getNumber(),
                user.getAreaCode(),
                user.getAge(),
                user.getEmail(),
                user.getIsActive());
    }
}
