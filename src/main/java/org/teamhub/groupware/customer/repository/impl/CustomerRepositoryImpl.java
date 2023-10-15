package org.teamhub.groupware.customer.repository.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.teamhub.groupware.common.payload.MemberDto;
import org.teamhub.groupware.customer.entity.Customer;
import org.teamhub.groupware.customer.entity.QCustomer;
import org.teamhub.groupware.customer.payload.CustomerDto;
import org.teamhub.groupware.customer.payload.CustomerSearchCondition;
import org.teamhub.groupware.customer.payload.QCustomerDto;
import org.teamhub.groupware.customer.repository.CustomerRepositoryCustom;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;
import static org.teamhub.groupware.common.entity.QMember.member;
import static org.teamhub.groupware.customer.entity.QCustomer.*;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public CustomerRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<CustomerDto> searchCustomers(CustomerSearchCondition condition, Pageable pageable) {
        List<CustomerDto> content = queryFactory
                .select(new QCustomerDto(
                        customer.customerId,
                        customer.company,
                        customer.department,
                        customer.position,
                        customer.email,
                        customer.name,
                        customer.tel,
                        customer.hp,
                        customer.rdate,
                        customer.ldate,
                        member.id
                ))
                .from(customer)
                .leftJoin(customer.member, member)
                .where(nameEq(condition.getName()),
                        telEq(condition.getTel()),
                        hpEq(condition.getHp()),
                        rdateEq(condition.getRdate()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Customer> countQuery = queryFactory
                .select(customer)
                .from(customer)
                .leftJoin(customer.member, member)
                .where(nameEq(condition.getName()),
                        telEq(condition.getTel()),
                        hpEq(condition.getHp()),
                        rdateEq(condition.getRdate()));

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }

    private BooleanExpression nameEq(String name) {
        return hasText(name) ? member.name.contains(name) : null;
    }

    private BooleanExpression telEq(String tel) {
        return hasText(tel) ? member.tel.contains(tel) : null;
    }

    private BooleanExpression hpEq(String hp) {
        return hasText(hp) ? member.hp.contains(hp) : null;
    }

    private BooleanExpression rdateEq(LocalDateTime rdate) {
        return rdate != null ? member.rdate.eq(rdate) : null;
    }

}
