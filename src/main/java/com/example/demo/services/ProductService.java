package com.example.demo.services;

import com.example.demo.exceptions.product.ProductAlreadyExistException;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.mappers.UserMapper;
import com.example.demo.models.*;
import com.example.demo.repositories.IProductRepository;
import com.example.demo.repositories.IUserProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    private final IUserProductsRepository userProductsRepository;

    @Override
    public List<ProductModel> findAll() {
        var result = productRepository.findAll();
        return ProductMapper.toModelList(result);
    }

    @Override
    public ProductPageModel findPagedList(PageRequest pageRequest) {
        var result = productRepository.findAll(pageRequest);
        return ProductMapper.toModelPagedList(result);
    }

    @Override
    public ProductModel create(CreateProductModel model) {
        var product = ProductMapper.toEntity(model);

        var existingProduct = productRepository.findByName(model.getName());

        if (existingProduct.isPresent())
            throw new ProductAlreadyExistException("Product with name " + model.getName() + " already exists");

        var savedProduct = productRepository.save(product);

        return ProductMapper.toModel(savedProduct);
    }

    @Override
    public ProductModel update(ProductModel model) {
        var entity = ProductMapper.toEntity(model);
        try {
            var result = productRepository.save(entity);
            return ProductMapper.toModel(result);
        } catch (Exception e) {
            throw new ProductAlreadyExistException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer productId) {
        var entity = productRepository.findById(productId).orElseThrow(() -> new ProductAlreadyExistException("Product not found."));
        productRepository.delete(entity);
    }

    @Override
    public List<UserProductsModel> findUserProductsAll() {
        return List.of();
    }
}
