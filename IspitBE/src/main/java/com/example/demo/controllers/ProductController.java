package com.example.demo.controllers;

import com.example.demo.models.CreateProductModel;
import com.example.demo.models.ProductPageModel;
import com.example.demo.models.ProductModel;
import com.example.demo.models.UserModel;
import com.example.demo.services.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final IProductService productService;

    @GetMapping("get-list")
    public List<ProductModel> getList() {
        return productService.findAll();
    }

    @GetMapping("get-page-list")
    public ProductPageModel getPageList(Integer pageNumber, Integer pageSize) {
        return productService.findPagedList(PageRequest.of(pageNumber, pageSize));
    }
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateProductModel productModel, BindingResult result) {
        return ResponseEntity.ok(productService.create(productModel));
    }
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid ProductModel productModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Not updated!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(productService.update(productModel));
    }
    @DeleteMapping("delete")
    public ResponseEntity<?> delete(Integer productId) {
        productService.delete(productId);
        return ResponseEntity.ok("");
    }
}
