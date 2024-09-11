package com.example.demo.models;

import lombok.Data;

@Data
public class CreateProductModel {
    private String name;
    private Integer number;
    private Integer user_id;
}
