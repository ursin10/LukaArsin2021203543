package com.example.demo.repositories;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.entities.UserProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByName(String name);

}
