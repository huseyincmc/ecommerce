package com.ecommerce.ecommerce.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@Builder
public class UserRequest {

    private String firstName;
    private String lastName;
    private String number;
    private String areaCode;
    @Min(value = 15,message = "15'ten kucuk")
    private Integer age;
    private String email;


}
