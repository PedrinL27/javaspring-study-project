package com.pedro.coursespring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pedro.coursespring.dto.product.ProductDTO;
import com.pedro.coursespring.entities.Product;
import com.pedro.coursespring.repositories.ProductRepository;
import com.pedro.coursespring.services.exceptions.DatabaseException;
import com.pedro.coursespring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductDTO> findAll() {
        List<Product> listProduct = repository.findAll();
        List<ProductDTO> listDTO = new ArrayList<>();

        for (Product product : listProduct) {
            ProductDTO dto = new ProductDTO(product);
            listDTO.add(dto);
        }
        return listDTO;
    }

    public ProductDTO findById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        Product product = repository.findById(id).get();
        ProductDTO dto = new ProductDTO(product); 
        return dto;
    }

    public ProductDTO insert(ProductDTO obj) {
        Product product = new Product();

        updateData(product, obj);
        product = repository.save(product);

        return new ProductDTO(product);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        try{
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public ProductDTO update(Long id, ProductDTO obj) {
        try {
            Product product = repository.getReferenceById(id);
            updateData(product, obj);
            repository.save(product);

            return new ProductDTO(product);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity, ProductDTO obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
    }
 
}
