package org.teamhub.groupware.customer.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.teamhub.groupware.customer.entity.Customer;
import org.teamhub.groupware.customer.mapper.CustomerMapper;
import org.teamhub.groupware.customer.payload.CustomerDto;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    public void setup() {

    }

    // JUnit test for
    @Test
    public void givenCustomerObject_whenPostCustomer_thenReturnCustomers() {
        // given - precondition or setup
        CustomerDto customerDto = CustomerDto.builder()
                .customerId(1L)
                .id(1L) // memberId
                .company("삼성전자")
                .department("마게팅")
                .position("대리")
                .name("홍길동")
                .email("ks@naver.com")
                .tel("02-1111-1111")
                .hp("010-1111-1111")
                .rdate(LocalDateTime.now())
                .ldate(null)
                .build();
        Customer customer = CustomerMapper.toEntity(customerDto);
        // when - action or the behavior that we are going test
        Customer savedCustomer = customerRepository.save(customer);
        // then - verify the output
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerId()).isEqualTo(1L);
    }
}
