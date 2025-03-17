package com.example.ems.service.master;

import com.example.ems.model.master.Client;
import com.example.ems.repository.master.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClientsById(Long id){
        return clientRepository.findById(id);
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client updatedClient){
        return clientRepository.findById(id)
            .map(client -> {
                client.setName(updatedClient.getName());
                client.setProjetName(updatedClient.getProjetName());
                client.setDescription(updatedClient.getDescription());
                client.setActive(updatedClient.getActive());
                client.setDeleted(updatedClient.getDeleted());
                return clientRepository.save(client);
            })
            .orElseThrow(()->new RuntimeException("Client not found with id: "+id));
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
}
