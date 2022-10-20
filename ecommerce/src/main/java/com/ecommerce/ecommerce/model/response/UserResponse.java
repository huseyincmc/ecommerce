package com.ecommerce.ecommerce.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String number;
    private String areaCode;
    private int age;
    private String email;
    private Boolean isActive=true;


    private List<UserProductResponse> productList;
}
