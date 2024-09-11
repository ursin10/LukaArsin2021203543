package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductPageModel {
    private List<ProductModel> Products;
    private int totalPages;
    private Long totalElements;
}
