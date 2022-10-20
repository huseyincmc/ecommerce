package com.ecommerce.ecommerce.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProductResponse {
    private String id;
    private String productName;
    private String brand;
    private Long price;
    private int unitsInStock;
}
