package com.pedro.coursespring.dto.category;

import java.io.Serializable;

import com.pedro.coursespring.entities.Category;

public class CategoryMinDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public CategoryMinDTO() {
    }

    public CategoryMinDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    
}
