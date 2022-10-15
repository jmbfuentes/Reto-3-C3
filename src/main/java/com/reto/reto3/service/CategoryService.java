package com.reto.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.reto3.model.Category;
import com.reto.reto3.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> obtenerCategoryCompleta() {
        return categoryRepository.obtenerCategoryCompleta();

    }

    public Optional<Category> obtenerCategoryId(Integer identificador) {
        return categoryRepository.obtenerCategoryId(identificador);
    }

    public Category salvarCategory(Category category) {
        if (category.getId() == null) {
            return categoryRepository.salvarCategory(category);
            
        }else{
            Optional<Category> categoryAuxiliar = categoryRepository.obtenerCategoryId(category.getId());
            if (categoryAuxiliar.isEmpty()) {
                return categoryRepository.salvarCategory(category);
                
            }else{
                return category;
            }
        }
    }


    public Category actualizarCategory(Category category) {
        if (category.getId() != null) {
            Optional<Category> e = categoryRepository.obtenerCategoryId(category.getId());
            if (!e.isEmpty()) {
                
                if (category.getName() != null) {
                    e.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    e.get().setDescription(category.getDescription());
                }
                categoryRepository.salvarCategory(e.get());
                return e.get();

            } else {
                return category;
            }
        } else {
            return category;
        }
    }

    public boolean borrarCategory(int categoryId) {
        boolean flag=false;
        Optional<Category> c= categoryRepository.obtenerCategoryId(categoryId);
        if(c.isPresent()){
            categoryRepository.delete(c.get());
            flag=true;
        }
        return flag;

    } 

}