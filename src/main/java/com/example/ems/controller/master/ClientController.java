package com.example.ems.controller.master;

import com.example.ems.model.master.Client;
import com.example.ems.service.master.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master/clients")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("{id}")
    public Optional<Client> getClientById(@PathVariable Long id){
        return clientService.getClientsById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }
}
