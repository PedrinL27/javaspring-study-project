package com.pedro.coursespring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pedro.coursespring.dto.user.UserDTO;
import com.pedro.coursespring.dto.user.UserInsertDTO;
import com.pedro.coursespring.entities.User;
import com.pedro.coursespring.repositories.UserRepository;
import com.pedro.coursespring.services.exceptions.DatabaseException;
import com.pedro.coursespring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> listUser = repository.findAll();
        List<UserDTO> listDTO = new ArrayList<>();

        for (User user : listUser) {
            UserDTO dto = new UserDTO(user);
            listDTO.add(dto);
        }
        return listDTO;
    }

    public UserDTO findById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        User user = repository.findById(id).get();
        UserDTO dto = new UserDTO(user);
        return dto;
    }

    public UserDTO insert(UserInsertDTO obj) {
        User user = new User();

        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPhone(obj.getPhone());
        user.setPassword(obj.getPassword());

        user = repository.save(user);

        return new UserDTO(user);
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

    public UserDTO update(Long id, UserInsertDTO obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            repository.save(entity);
            UserDTO dto = new UserDTO(entity);
            
            return dto;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, UserInsertDTO obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
