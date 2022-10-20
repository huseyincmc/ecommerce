package com.ecommerce.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String productName;
    private String brand;
    private Long price;
    private int unitsInStock;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "user_id")
    private User user; // sor

    public Product(String id, String productName, String brand, Long price, int unitsInStock) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.unitsInStock = unitsInStock;
    }
}
