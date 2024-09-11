package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

import java.awt.*;

@Data
@Builder
public class ProductModel {
    private int id;
    private String name;
    private Integer number;
    private Integer user_id;
}
