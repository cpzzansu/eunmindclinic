package org.teamhub.groupware.common.payload;

import lombok.Data;
import org.teamhub.groupware.common.entity.Status;

@Data
public class MemberSearchCondition {
    private String company;
    private String name;
    private String tel;
    private String hp;
    private Status status;
}
