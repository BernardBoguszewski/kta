package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.builders.ClientBuilder;
import pl.com.britenet.kta.dtos.ClientDto;
import pl.com.britenet.kta.entity.crm.Client;
import pl.com.britenet.kta.entity.crm.ContactType;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ClientBuilder clientBuilder;

    public ClientService(ClientRepository clientRepository, ClientBuilder clientBuilder) {
        this.clientRepository = clientRepository;
        this.clientBuilder = clientBuilder;
    }

    @Transactional
    public void createClient(ClientDto clientDto) {
        Client client = clientBuilder.create(clientDto);
        clientRepository.save(client);
    }

    @Transactional
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client getClient(String id) {
        Client client = clientRepository.findOne(id);
        if (client ==  null)
            throw new BadRequestException("Client does not exist");
        else
            return client;
    }

    @Transactional
    public void updateClient(String id, ClientDto clientDto) {
        Client client = clientRepository.findOne(id);
        if (client ==  null)
            throw new BadRequestException("Client does not exist");
        else {
            client.setName(clientDto.getName());
            client.setAddress(clientDto.getAddress());
            client.setEmail(clientDto.getEmail());
            client.setPhoneNumber(clientDto.getPhoneNumber());
            ContactType contactType = ContactType.valueOf(clientDto.getContactType());
            client.setContactType(contactType);
            clientRepository.save(client);
        }
    }

    @Transactional
    public void deleteClient(String id) {
        Client client = clientRepository.findOne(id);
        if (client ==  null)
            throw new BadRequestException("Client does not exist");
        else
            clientRepository.delete(id);
    }
}
