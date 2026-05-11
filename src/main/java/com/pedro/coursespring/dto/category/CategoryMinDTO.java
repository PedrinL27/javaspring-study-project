package com.pedro.coursespring.dto.category;

import com.pedro.coursespring.entities.Category;

public class CategoryMinDTO {

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
