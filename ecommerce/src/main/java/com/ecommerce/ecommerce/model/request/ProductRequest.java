package com.ecommerce.ecommerce.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class ProductRequest {

    private String productName;
    private String brand;
    private Long price;
    private int unitsInStock;
    private String userId;


}
