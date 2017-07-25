package pl.com.britenet.kta.services;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.britenet.kta.builders.ClientBuilder;
import pl.com.britenet.kta.dtos.ClientDto;
import pl.com.britenet.kta.entity.crm.Client;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.ClientRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private Client client;

    @Mock
    private ClientBuilder clientBuilder;

    private ClientDto clientDto;
    private ClientService clientService;

    private String goodId = "good id";
    private String badId = "bad id";

    @Before
    public void setUp() {
        clientDto = new ClientDto("imie", "adres", "mail@mail.com", "123321123", "OSOBA_FIZYCZNA");
        clientService = new ClientService(clientRepository, clientBuilder);
    }

    @Test
    public void shouldCreateClient() {
        when(clientBuilder.create(clientDto)).thenReturn(client);

        clientService.createClient(clientDto);

        verify(clientRepository).save(client);
    }

    @Test
    public void shouldThrowExceptionWhenClientDoesNotExist() {
        exception.expect(BadRequestException.class);
        when(clientRepository.findOne(badId)).thenReturn(null);

        clientService.getClient(badId);
    }

    @Test
    public void shouldFindClientIfExist() {
        when(clientRepository.findOne(goodId)).thenReturn(client);

        ClientDto clientReturned = clientService.getClient(goodId);

        assertEquals(client.getId(), clientReturned.getId());
    }

    @Test
    public void shouldFindAllClients(){

        clientService.getAllClients();

        verify(clientRepository).findAll();
    }

    @Test
    public void shouldDeleteClient(){
        when(clientRepository.findOne(goodId)).thenReturn(client);

        clientService.deleteClient(goodId);

        verify(clientRepository).delete(goodId);
    }

}
