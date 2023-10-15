package org.teamhub.groupware.customer.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.teamhub.groupware.customer.repository.CustomerRepositoryCustom;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public CustomerRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


}
