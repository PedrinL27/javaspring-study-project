package com.pedro.coursespring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.coursespring.dto.category.CategoryDTO;
import com.pedro.coursespring.entities.Category;
import com.pedro.coursespring.repositories.CategoryRepository;
import com.pedro.coursespring.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryDTO> findAll() {
        List<Category> listCategory = repository.findAll();
        List<CategoryDTO> listDTO = new ArrayList<>();

        for (Category category : listCategory) {
            CategoryDTO dto = new CategoryDTO(category);
            listDTO.add(dto);
        }
        return listDTO;
    }

    public CategoryDTO findById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        Category category = repository.findById(id).get();
        CategoryDTO dto = new CategoryDTO(category);
        return dto;
    }

}
