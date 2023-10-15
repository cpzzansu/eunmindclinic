package org.teamhub.groupware.customer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.teamhub.groupware.customer.payload.CustomerDto;
import org.teamhub.groupware.customer.payload.CustomerSearchCondition;

public interface CustomerRepositoryCustom {

    Page<CustomerDto> searchCustomers(CustomerSearchCondition customerSearchCondition, Pageable pageable);
}
