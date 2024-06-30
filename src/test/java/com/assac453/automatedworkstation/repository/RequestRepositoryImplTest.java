package com.assac453.automatedworkstation.repository;

import com.assac453.automatedworkstation.config.HibernateConfiguration;
import com.assac453.automatedworkstation.entity.Client;
import com.assac453.automatedworkstation.entity.Contract;
import com.assac453.automatedworkstation.entity.Request;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {HibernateConfiguration.class})
@TestPropertySource(locations = "classpath:application-test.yaml")
@Transactional
public class RequestRepositoryImplTest {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContractRepository contractRepository;

    private Client client;
    private Contract contract;

    @BeforeEach
    public void setUp() {
        client = createClient();
        clientRepository.save(client);

        contract = createContract();
        contractRepository.save(contract);
    }

    @Test
    public void save_ShouldExist() {
        Request request = createRequest(client, contract);
        requestRepository.save(request);
        assertThat(request.getId()).isNotNull();
    }

    @Test
    public void findById_ShouldExist() {
        Request request = createRequest(client, contract);
        requestRepository.save(request);
        Request foundRequest = requestRepository.findById(request.getId());
        assertThat(foundRequest).isEqualTo(request);
    }

    @Test
    public void findAll_ShouldContain() {
        Request request1 = createRequest(client, contract);
        Request request2 = createRequest(client, contract);
        request2.setApprovedStatus(false);
        requestRepository.save(request1);
        requestRepository.save(request2);

        List<Request> requests = requestRepository.findAll();
        assertThat(requests).containsExactlyInAnyOrder(request1, request2);
    }

    @Test
    public void findByApprovedStatus_ShouldExist() {
        Request request = createRequest(client, contract);
        requestRepository.save(request);

        List<Request> foundRequests = requestRepository.findByApprovedStatus(request.getApprovedStatus());
        assertThat(foundRequests).contains(request);
    }

    @Test
    public void update_ShouldCorrect() {
        Request request = createRequest(client, contract);
        requestRepository.save(request);
        request.setApprovedStatus(false);
        requestRepository.update(request);
        Request updatedRequest = requestRepository.findById(request.getId());
        assertThat(updatedRequest.getApprovedStatus()).isFalse();
    }

    @Test
    public void delete_ShouldNotExist() {
        Request request = createRequest(client, contract);
        requestRepository.save(request);
        requestRepository.delete(request.getId());
        Request deletedRequest = requestRepository.findById(request.getId());
        assertThat(deletedRequest).isNull();
    }

    private Request createRequest(Client client, Contract contract) {
        Random random = new Random();
        return Request.builder()
                .approvedAmount(BigDecimal.valueOf(10000.00))
                .approvedTerm(random.nextInt(1, 12))
                .approvedStatus(random.nextBoolean())
                .client(client)
                .build();
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

    private Contract createContract() {
        return Contract.builder()
                .signedDate(new Date(System.currentTimeMillis()))
                .signedStatus(System.currentTimeMillis() % 2 == 0)
                .build();
    }
}
