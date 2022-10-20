package com.ecommerce.ecommerce.model.response.converter;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.model.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class ProductResponseConverter {

    private final ProductUserResponseConverter productUserResponseConverter;

    public ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getProductName(),
                product.getBrand(),
                product.getPrice(),
                product.getUnitsInStock(),
                productUserResponseConverter.convertToUserProduct(product.getUser())

        );


    }
}
