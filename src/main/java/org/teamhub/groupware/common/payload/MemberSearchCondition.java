package org.teamhub.groupware.common.payload;

import lombok.Data;

@Data
public class MemberSearchCondition {
    private String company;
    private String name;
    private String tel;
    private String hp;
    private Integer status;
}
