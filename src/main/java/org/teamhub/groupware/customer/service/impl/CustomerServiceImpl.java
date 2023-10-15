package org.teamhub.groupware.customer.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.customer.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl {
    private final CustomerRepository customerRepository;


}
