package com.ecommerce.ecommerce.model.response.converter;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.model.response.UserProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component

public class UserProductResponseConverter {

    public UserProductResponse convertToProductUser(Product product){
        return new UserProductResponse(
                product.getId(),
                product.getProductName(),
                product.getBrand(),
                product.getPrice(),
                product.getUnitsInStock());
    }
}
