package org.teamhub.groupware.customer.mapper;

import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.customer.entity.Customer;
import org.teamhub.groupware.customer.payload.CustomerDto;

public class CustomerMapper {

    public static CustomerDto toDto(Customer customer) {
        CustomerDto.CustomerDtoBuilder builder = CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .company(customer.getCompany())
                .department(customer.getDepartment())
                .position(customer.getPosition())
                .name(customer.getName())
                .email(customer.getEmail())
                .tel(customer.getTel())
                .hp(customer.getHp())
                .rdate(customer.getRdate())
                .ldate(customer.getLdate());

        if (customer.getMember() != null) {
            builder.id(customer.getMember().getId());
        }

        return builder.build();
    }

    public static Customer toEntity(CustomerDto customerDto) {
        Customer.CustomerBuilder builder = Customer.builder()
                .customerId(customerDto.getCustomerId())
                .company(customerDto.getCompany())
                .department(customerDto.getDepartment())
                .position(customerDto.getPosition())
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .tel(customerDto.getTel())
                .hp(customerDto.getHp())
                .rdate(customerDto.getRdate())
                .ldate(customerDto.getLdate());

        if (customerDto.getId() != null) {
            builder.member(Member.builder().id(customerDto.getId()).build());
        }
        return builder.build();
    }
}
