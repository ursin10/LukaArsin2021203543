package com.example.demo.services;

import com.example.demo.models.CreateProductModel;
import com.example.demo.models.ProductModel;
import com.example.demo.models.ProductPageModel;
import com.example.demo.models.UserProductsModel;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IProductService {
    List<ProductModel> findAll();
    ProductPageModel findPagedList(PageRequest pageRequest);
    ProductModel create(@Valid CreateProductModel model);
    ProductModel update(@Valid ProductModel model);
    void delete(Integer productId);
    List<UserProductsModel> findUserProductsAll();
}
