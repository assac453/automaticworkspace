package com.assac453.automatedworkstation.repository;


import com.assac453.automatedworkstation.config.HibernateConfiguration;
import com.assac453.automatedworkstation.entity.Client;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {HibernateConfiguration.class})
@TestPropertySource(locations = "classpath:application-test.yaml")
@Transactional
public class ClientRepositoryImplTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void saveShouldExist() {
        Client client = createClient();
        clientRepository.save(client);
        assertThat(client.getId()).isNotNull();
    }

    @Test
    public void findById_ShouldExist() {
        Client client = createClient();
        clientRepository.save(client);
    }

    @Test
    public void findAll_ShouldContain() {
        Client client1 = createClient();
        Client client2 = createClient();
        client2.setFio("Another Name");
        clientRepository.save(client1);
        clientRepository.save(client2);

        List<Client> clients = clientRepository.findAll();
        assertThat(clients).containsExactlyInAnyOrder(client1, client2);
    }

    @Test
    public void update_ShouldCorrect() {
        Client client = createClient();
        clientRepository.save(client);
        client.setFio("Updated Name");
        clientRepository.update(client);
        Client updatedClient = clientRepository.findById(client.getId());
        assertThat(updatedClient.getFio()).isEqualTo("Updated Name");
    }

    @Test
    public void delete_ShouldNotExist() {
        Client client = createClient();
        clientRepository.save(client);
        clientRepository.delete(client);
        Client deletedClient = clientRepository.findById(client.getId());
        assertThat(deletedClient).isNull();
    }

//    @Test
//    public void findByFio_ShouldExist() {
//        Client client = createClient();
//        clientRepository.save(client);
//        Client foundClient = clientRepository.findByFio(client.getFio());
//        assertThat(foundClient).isEqualTo(client);
//    }

    @Test
    public void findByPassport_ShouldExist() {
        Client client = createClient();
        clientRepository.save(client);
        Client foundClient = clientRepository.findByPassport(client.getPassport());
        assertThat(foundClient).isEqualTo(client);
    }

    @Test
    public void findByContactPhone_ShouldExist() {
        Client client = createClient();
        clientRepository.save(client);
        Client foundClient = clientRepository.findByContactPhone(client.getContactPhone());
        assertThat(foundClient).isEqualTo(client);
    }

    private Client createClient() {
        return Client.builder()
                .fio(RandomGeneratorUtil.createRandomString(30))
                .passport(RandomGeneratorUtil.createRandomNumbers(10))
                .familyStatus(System.currentTimeMillis() % 2 == 0)
                .registrationAddress(RandomGeneratorUtil.createRandomString(50))
                .contactPhone(RandomGeneratorUtil.createRandomNumbers(11))
                .build();
    }

}
