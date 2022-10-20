package com.ecommerce.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")

    private String id;
    private String firstName;
    private String lastName;
    private String number;
    private String areaCode;
    private int age;
    private String email;
    private Boolean isActive=true;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Product> products;

    public User(String id, String firstName, String lastName, String number, String areaCode, int age, String email, Boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.areaCode = areaCode;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }
}
