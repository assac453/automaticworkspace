package com.assac453.automatedworkstation.repository;

import com.assac453.automatedworkstation.config.HibernateConfiguration;
import com.assac453.automatedworkstation.entity.Client;
import com.assac453.automatedworkstation.entity.EmploymentInfo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {HibernateConfiguration.class})
@TestPropertySource(locations = "classpath:application-test.yaml")
@Transactional
public class EmploymentInfoRepositoryImplTest {

    @Autowired
    private EmploymentInfoRepository employmentInfoRepository;

    @Autowired
    private ClientRepository clientRepository;

    private Client client;

    @BeforeEach
    public void setUp() {
        client = createClient();
        clientRepository.save(client);
    }

    @Test
    public void save_ShouldExist() {
        EmploymentInfo employmentInfo = createEmploymentInfo(client);
        employmentInfoRepository.save(employmentInfo);
        assertThat(employmentInfo.getId()).isNotNull();
    }

    @Test
    public void findById_ShouldExist() {
        EmploymentInfo employmentInfo = createEmploymentInfo(client);
        employmentInfoRepository.save(employmentInfo);
        EmploymentInfo foundEmploymentInfo = employmentInfoRepository.findById(employmentInfo.getId());
        assertThat(foundEmploymentInfo).isEqualTo(employmentInfo);
    }

    @Test
    public void findAll_ShouldContain() {
        EmploymentInfo employmentInfo1 = createEmploymentInfo(client);
        EmploymentInfo employmentInfo2 = createEmploymentInfo(client);
        employmentInfo2.setPosition("Another Position");
        employmentInfoRepository.save(employmentInfo1);
        employmentInfoRepository.save(employmentInfo2);

        List<EmploymentInfo> employmentInfos = employmentInfoRepository.findAll();
        assertThat(employmentInfos).containsExactlyInAnyOrder(employmentInfo1, employmentInfo2);
    }

    @Test
    public void update_ShouldCorrect() {
        EmploymentInfo employmentInfo = createEmploymentInfo(client);
        employmentInfoRepository.save(employmentInfo);
        employmentInfo.setPosition("Updated Position");
        employmentInfoRepository.update(employmentInfo);
        EmploymentInfo updatedEmploymentInfo = employmentInfoRepository.findById(employmentInfo.getId());
        assertThat(updatedEmploymentInfo.getPosition()).isEqualTo("Updated Position");
    }

    @Test
    public void delete_ShouldNotExist() {
        EmploymentInfo employmentInfo = createEmploymentInfo(client);
        employmentInfoRepository.save(employmentInfo);
        employmentInfoRepository.delete(employmentInfo.getId());
        EmploymentInfo deletedEmploymentInfo = employmentInfoRepository.findById(employmentInfo.getId());
        assertThat(deletedEmploymentInfo).isNull();
    }

    private EmploymentInfo createEmploymentInfo(Client client) {
        Random random = new Random();
        return EmploymentInfo.builder()
                .workPeriod(random.nextInt(1, 12))
                .position(RandomGeneratorUtil.createRandomString(10))
                .organization(RandomGeneratorUtil.createRandomNumbers(30))
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
}
