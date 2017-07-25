package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dtos.ClientDto;
import pl.com.britenet.kta.entity.crm.Client;
import pl.com.britenet.kta.services.ClientService;

import java.util.List;

/**
 * Created by Britenet on 2017-07-17.
 */
@RestController
@RequestMapping("/clients")
public class ClientsController {

    private ClientService clientService;

    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientDto createClient(@RequestBody ClientDto clientDto){
        clientDto.validate();
        return clientService.createClient(clientDto);
    }

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable String id){
        return clientService.getClient(id);
    }

    @PutMapping("/{id}")
    public ClientDto updateClient(@PathVariable String id, @RequestBody ClientDto clientDto){
        clientDto.validate();
        return clientService.updateClient(id, clientDto);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id){
        clientService.deleteClient(id);
    }
}
