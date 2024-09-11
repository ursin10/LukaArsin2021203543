package com.example.demo.mappers;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.entities.UserProducts;
import com.example.demo.models.*;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static Product toEntity(ProductModel model) {
        Product product = new Product();
        product.setId(model.getId());
        product.setName(model.getName());
        product.setNumber(model.getNumber());
        product.setUserId(model.getUser_id());
        return product;
    }

    public static Product toEntity(CreateProductModel model) {
        Product product = new Product();
            product.setName(model.getName());
            product.setNumber(model.getNumber());
            product.setUserId(model.getUser_id());
        return product;
    }

    public static ProductModel toModel(Product entity) {
        return ProductModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .number(entity.getNumber())
                .user_id(entity.getUserId())
                .build();
    }

    public static List<ProductModel> toModelList(List<Product> entities) {
        var list = new ArrayList<ProductModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static ProductPageModel toModelPagedList(Page<Product> pageEntity) {
        return ProductPageModel.builder()
                .Products(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getTotalElements())
                .build();
    }
}
