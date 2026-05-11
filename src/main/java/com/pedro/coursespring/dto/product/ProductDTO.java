package com.pedro.coursespring.dto.product;

import java.util.HashSet;
import java.util.Set;

import com.pedro.coursespring.dto.category.CategoryMinDTO;
import com.pedro.coursespring.entities.Category;
import com.pedro.coursespring.entities.Product;

public class ProductDTO extends ProductMinDTO {

    Set<CategoryMinDTO> categories = new HashSet<>();

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        super(product);
        for (Category category : product.getCategories()) {
                categories.add(new CategoryMinDTO(category));
        }
    }

    public Set<CategoryMinDTO> getCategoryMinDTO() {
        return categories;
    }  
}
