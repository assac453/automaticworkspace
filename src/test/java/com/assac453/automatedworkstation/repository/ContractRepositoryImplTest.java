package com.assac453.automatedworkstation.repository;

import com.assac453.automatedworkstation.config.HibernateConfiguration;
import com.assac453.automatedworkstation.entity.Contract;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {HibernateConfiguration.class})
@TestPropertySource(locations = "classpath:application-test.yaml")
@Transactional
public class ContractRepositoryImplTest {
    @Autowired
    private ContractRepository contractRepository;

    @Test
    public void save_ShouldExist() {
        Contract contract = createContract();
        contractRepository.save(contract);
        assertThat(contract.getId()).isNotNull();
    }

    @Test
    public void findById_ShouldExist() {
        Contract contract = createContract();
        contractRepository.save(contract);
        Contract foundContract = contractRepository.findById(contract.getId());
        assertThat(foundContract).isEqualTo(contract);
    }

    @Test
    public void findAll_ShouldContain() {
        Contract contract1 = createContract();
        Contract contract2 = createContract();
        contract2.setSignedStatus(false);
        contractRepository.save(contract1);
        contractRepository.save(contract2);

        List<Contract> contracts = contractRepository.findAll();
        assertThat(contracts).containsExactlyInAnyOrder(contract1, contract2);
    }

    @Test
    public void findBySignedStatus_ShouldExist() {
        Contract contract = createContract();
        contractRepository.save(contract);

        List<Contract> foundContracts = contractRepository.findBySignedStatus(contract.getSignedStatus());
        assertThat(foundContracts).contains(contract);
    }

    @Test
    public void update_ShouldCorrect() {
        Contract contract = createContract();
        contractRepository.save(contract);
        contract.setSignedStatus(false);
        contractRepository.update(contract);
        Contract updatedContract = contractRepository.findById(contract.getId());
        assertThat(updatedContract.getSignedStatus()).isFalse();
    }

    @Test
    public void delete_ShouldNotExist() {
        Contract contract = createContract();
        contractRepository.save(contract);
        contractRepository.delete(contract.getId());
        Contract deletedContract = contractRepository.findById(contract.getId());
        assertThat(deletedContract).isNull();
    }

    private Contract createContract() {
        return Contract.builder()
                .signedDate(new Date(System.currentTimeMillis()))
                .signedStatus(System.currentTimeMillis() % 2 == 0)
                .build();
    }
}
