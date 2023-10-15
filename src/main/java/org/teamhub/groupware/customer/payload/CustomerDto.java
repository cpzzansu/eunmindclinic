package org.teamhub.groupware.customer.payload;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CustomerDto {
    @NotNull
    private Long customerId;
    @NotBlank
    private String company;
    private String department;
    private String position;
    @NotBlank
    private String email;
    private String name;
    private String tel;
    private String hp;
    private LocalDateTime rdate;
    private LocalDateTime ldate;
    @NotNull
    private Long id;

    @QueryProjection
    public CustomerDto(Long customerId, String company, String department, String position, String email, String name, String tel, String hp, LocalDateTime rdate, LocalDateTime ldate, Long id) {
        this.customerId = customerId;
        this.company = company;
        this.department = department;
        this.position = position;
        this.email = email;
        this.name = name;
        this.tel = tel;
        this.hp = hp;
        this.rdate = rdate;
        this.ldate = ldate;
        this.id = id;
    }
}
