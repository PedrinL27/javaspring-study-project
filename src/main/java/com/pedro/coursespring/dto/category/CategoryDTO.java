package com.pedro.coursespring.dto.category;

import java.util.HashSet;
import java.util.Set;

import com.pedro.coursespring.dto.product.ProductMinDTO;
import com.pedro.coursespring.entities.Category;
import com.pedro.coursespring.entities.Product;

public class CategoryDTO extends CategoryMinDTO {
    private static final long serialVersionUID = 1L;

    private Set<ProductMinDTO> products = new HashSet<>();

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        super(category);
        for (Product product : category.getProducts()) {
            products.add(new ProductMinDTO(product));
        }
    }

    public Set<ProductMinDTO> getProducts() {
        return products;
    }
}
