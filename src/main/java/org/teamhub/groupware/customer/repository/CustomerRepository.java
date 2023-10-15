package org.teamhub.groupware.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.teamhub.groupware.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom, QuerydslPredicateExecutor {
}
