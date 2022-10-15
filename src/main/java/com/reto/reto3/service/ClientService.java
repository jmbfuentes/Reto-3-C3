package com.reto.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.reto3.model.Client;
import com.reto.reto3.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> obtenerClient() {
        return clientRepository.obtenerClient();

    }

    public Optional<Client> obtenerClientId(Integer id) {
        return clientRepository.obtenerClientId(id);
    }    

    public Client salvarClient(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.salvarClient(client); 
        
        }else{
            Optional <Client> clientAuxiliar = clientRepository.obtenerClientId(client.getIdClient());
            if (clientAuxiliar.isEmpty()) {
            return clientRepository.salvarClient(client);
                
            }else{
                return client;
            }
           
        }
        
    }
    

    public Client actualizarClient(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = clientRepository.obtenerClientId(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getEmail() != null) {
                    e.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }

                clientRepository.salvarClient(e.get());
                return e.get();

            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean borrarClient(int clientId) {
        boolean flag=false;
        Optional<Client> c= clientRepository.obtenerClientId(clientId);
        if(c.isPresent()){
            clientRepository.delete(c.get());
            flag=true;
        }
        return flag;

    } 


    
}
