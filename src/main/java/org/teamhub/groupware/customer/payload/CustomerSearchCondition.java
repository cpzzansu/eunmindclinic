package org.teamhub.groupware.customer.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerSearchCondition {
    private String name;
    private String tel;
    private String hp;
    private LocalDateTime rdate;
}
