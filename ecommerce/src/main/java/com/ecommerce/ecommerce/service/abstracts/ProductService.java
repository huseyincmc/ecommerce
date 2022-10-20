package com.ecommerce.ecommerce.service.abstracts;



import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.model.request.ProductRequest;
import com.ecommerce.ecommerce.model.response.ProductResponse;
import com.ecommerce.ecommerce.model.response.UserProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse addProduct(ProductRequest productRequest);

    ProductResponse updateProduct(String id, ProductRequest productRequest);

    void deleteProduct(String id);

    List<ProductResponse> getAllProducts();

    List<UserProductResponse> findAllByPriceLessThanEqual(Long price);
}
