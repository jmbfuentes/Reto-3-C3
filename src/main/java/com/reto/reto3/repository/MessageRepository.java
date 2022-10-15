package com.reto.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.model.Message;
import com.reto.reto3.repository.CRUD.MessageCrudRepoInterfaz;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepoInterfaz messageCrudRepoInterfaz;

    public List<Message> obtenerMessageCompleta(){
        return(List<Message>) messageCrudRepoInterfaz.findAll();
    }

    public Optional<Message> obtenerMessageId(Integer idMessage){
        return messageCrudRepoInterfaz.findById(idMessage);
    }
    public Message salvarMessage(Message message){
        return messageCrudRepoInterfaz.save(message);

    }

    public void delete(Message message) {
        messageCrudRepoInterfaz.delete(message);
        
    }


}
