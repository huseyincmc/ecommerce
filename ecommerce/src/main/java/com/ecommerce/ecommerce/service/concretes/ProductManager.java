package com.ecommerce.ecommerce.service.concretes;

import com.ecommerce.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.model.request.ProductRequest;
import com.ecommerce.ecommerce.model.response.ProductResponse;
import com.ecommerce.ecommerce.model.response.UserProductResponse;
import com.ecommerce.ecommerce.model.response.converter.ProductResponseConverter;
import com.ecommerce.ecommerce.model.response.converter.UserProductResponseConverter;
import com.ecommerce.ecommerce.repository.ProductRepository;
import com.ecommerce.ecommerce.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ProductResponseConverter productResponseConverter;
    private final UserManager userManager;
    private final UserProductResponseConverter userProductResponseConverter;

    //protected olunca new lendiği yerden ya da constractur enjektion yapıldıgı yerden cagrılabilr
    //productmanager da userrepository ye kadar alt tabakaya inmemek icin(userrepositorynin yaptıgı isi usermanager da ypabiliroyrm)bu yuzden
    //repository yi buraya enjekte etmeme gerek yok
    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
    User user = userManager.findById(productRequest.getUserId());
    Product product = productRepository.save(Product.builder()
            .productName(productRequest.getProductName())
            .brand(productRequest.getBrand())
            .price(productRequest.getPrice())
            .unitsInStock(productRequest.getUnitsInStock())
            .user(user)
            .build());
    return productResponseConverter.from(product);
    }

    @Override
    public ProductResponse updateProduct(String id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product couldn't be found by following id:" +id));
        product.setProductName(productRequest.getProductName());
        product.setBrand(productRequest.getBrand());
        product.setPrice(productRequest.getPrice());
        product.setUnitsInStock(productRequest.getUnitsInStock());
        Product updatedProduct=productRepository.save(product);
        return productResponseConverter.from(updatedProduct);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll().stream().map(productResponseConverter::from).collect(Collectors.toList());
    }

    @Override
    public List<UserProductResponse> findAllByPriceLessThanEqual(Long price) {
        return productRepository.findAllByPriceLessThanEqual(price).stream().map(userProductResponseConverter::convertToProductUser).toList();
    }
}
