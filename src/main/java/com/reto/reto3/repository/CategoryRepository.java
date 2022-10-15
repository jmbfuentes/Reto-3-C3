package com.reto.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.model.Category;
import com.reto.reto3.repository.CRUD.CategoryCrudRepoInterfaz;

@Repository
public class CategoryRepository {
    
    @Autowired
    public CategoryCrudRepoInterfaz categoryCrudRepoInterfaz; 
    
    public List<Category> obtenerCategoryCompleta(){
        return (List<Category>) categoryCrudRepoInterfaz.findAll();
    }

    public Optional<Category> obtenerCategoryId(Integer identificador) {
        return categoryCrudRepoInterfaz.findById(identificador);
    }

    public Category salvarCategory(Category category) {
        return categoryCrudRepoInterfaz.save(category);
    }

    public void delete(Category category) {
        categoryCrudRepoInterfaz.delete(category);
        
    }
  


    //public Optional<Category> getCategory(int id){
      //  return categoryCrudRepositoryInterfaz.findById(id);
    //}

   
}
 
