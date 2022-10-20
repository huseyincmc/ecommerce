package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.request.ProductRequest;
import com.ecommerce.ecommerce.model.response.ProductResponse;
import com.ecommerce.ecommerce.model.response.UserProductResponse;
import com.ecommerce.ecommerce.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest){
        log.info("addProduct method started");
        log.info("added: {}",productRequest);
        return productService.addProduct(productRequest);
    }

    @GetMapping
    public List<ProductResponse> getAllProduct(){
        log.info("getAllProduct method started");
        log.info("All product have been bought:");
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable String id,@RequestBody ProductRequest productRequest){
        return productService.updateProduct(id,productRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }
    @GetMapping("/price")
    public List<UserProductResponse> findAllPriceLessThanEqual(@RequestParam Long price){
        return productService.findAllByPriceLessThanEqual(price);
    }
}
