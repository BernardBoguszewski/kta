package pl.com.britenet.kta.builders;

import org.springframework.stereotype.Component;
import pl.com.britenet.kta.dtos.ClientDto;
import pl.com.britenet.kta.entity.crm.Client;
import pl.com.britenet.kta.entity.crm.ContactType;

@Component
public class ClientBuilder {

    public Client create(ClientDto clientDto){
        String type = clientDto.getContactType().toUpperCase();
        ContactType contactType = ContactType.valueOf(clientDto.getContactType());
        return new Client(clientDto.getName(), clientDto.getAddress(), clientDto.getEmail(), clientDto.getPhoneNumber(), contactType);
    }
}
