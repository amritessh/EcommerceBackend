package com.ecommerce.backend.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import org.springframework.data.annotation.Id;
//import javax.validation.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString
@Setter
@Getter
@Table(name="categories")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private @NotNull String categoryName;

    private @NotNull String description;

    private @NotNull String imageUrl;


    public Category() {
    }

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public Category(String categoryName, String description, String imageUrl) {
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
    }






}
