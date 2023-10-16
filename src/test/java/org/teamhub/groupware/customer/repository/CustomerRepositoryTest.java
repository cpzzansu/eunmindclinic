package org.teamhub.groupware.customer.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.payload.MemberDto;
import org.teamhub.groupware.customer.entity.Customer;
import org.teamhub.groupware.customer.mapper.CustomerMapper;
import org.teamhub.groupware.customer.payload.CustomerDto;
import org.teamhub.groupware.customer.payload.CustomerSearchCondition;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    // JUnit test for post customer
    @Test
    @DisplayName("JUnit test for post customer")
    public void givenCustomerObject_whenPostCustomer_thenReturnCustomers() {
        // given - precondition or setup
        CustomerDto customerDto = CustomerDto.builder()
                .customerId(1L)
                .id(Member.builder().id(1L).build().getId()) // memberId(FK)
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

    // JUnit test for findAll
    @Test
    @DisplayName("JUnit test for findAll")
    public void givenCustomerObject_whenFindAllCustomer_thenReturnAll() {
        // given - precondition or setup
        CustomerDto customerDto = CustomerDto.builder()
                .customerId(1L)
                .id(Member.builder().id(1L).build().getId()) // memberId(FK)
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
        Customer savedCustomer = customerRepository.save(customer);
        // when - action or the behavior that we are going test
        List<Customer> customerList = customerRepository.findAll();
        // then - verify the output
        assertThat(customerList).isNotNull();
    }

    // JUnit test for findById
    @Test
    @DisplayName("JUnit test for findById")
    public void givenCustomerObject_whenFindById_thenReturnId() {
        // given - precondition or setup
        CustomerDto customerDto = CustomerDto.builder()
                .customerId(1L)
                .id(Member.builder().id(1L).build().getId()) // memberId(FK)
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
        Customer savedCustomer = customerRepository.save(customer);
        // when - action or the behavior that we are going test
        Optional<Customer> customerOptional = customerRepository.findById(savedCustomer.getCustomerId());
        // then - verify the output
        assertThat(customerOptional).isNotNull();
        assertThat(savedCustomer.getCustomerId()).isEqualTo(1L);
    }

    // JUnit test for dynamicQuery with Paging
//    @Test
//    public void given_when_then() {
//        // given - precondition or setup
//        LocalDateTime now = LocalDateTime.now();
//
//        CustomerDto customerDto = CustomerDto.builder()
//                .customerId(1L)
//                .id(Member.builder().id(1L).build().getId()) // memberId(FK)
//                .company("삼성전자")
//                .department("마게팅")
//                .position("대리")
//                .name("홍길동")
//                .email("ks@naver.com")
//                .tel("02-1111-1111")
//                .hp("010-1111-1111")
//                .rdate(now)
//                .ldate(null)
//                .build();
//        Customer customer = CustomerMapper.toEntity(customerDto);
//        customerRepository.save(customer);
//        // when - action or the behavior that we are going test
//        CustomerSearchCondition condition = new CustomerSearchCondition();
//        condition.setName("홍길동");
//        condition.setTel("02-1111-1111");
//        condition.setHp("010-1111-1111");
//        condition.setRdate(now);
//        PageRequest pageRequest = PageRequest.of(0, 10);
//
//        Page<CustomerDto> result = customerRepository.searchCustomers(condition, pageRequest);
//        // then - verify the output
//        assertThat(result.getSize()).isEqualTo(10);
//        assertThat(result.getTotalElements()).isEqualTo(1);
//    }
}
