package com.reto.reto3.repository.CRUD;

import org.springframework.data.repository.CrudRepository;

import com.reto.reto3.model.Message;

public interface MessageCrudRepoInterfaz extends CrudRepository<Message,Integer>{
    
}
