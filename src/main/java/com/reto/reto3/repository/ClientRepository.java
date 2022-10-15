package com.reto.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.model.Client;
import com.reto.reto3.repository.CRUD.ClientCrudRepoInterfaz;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepoInterfaz clientCrudRepoInterfaz;

    public List<Client> obtenerClient() {
        return (List<Client>) clientCrudRepoInterfaz.findAll();

    }

    public Client salvarClient(Client client) {
        return clientCrudRepoInterfaz.save(client);
    }

    public Optional<Client> obtenerClientId(Integer id) {
        return clientCrudRepoInterfaz.findById(id);
    }

    public void delete(Client client) {
        clientCrudRepoInterfaz.delete(client);
        
    }
    
}
