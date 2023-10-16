package org.teamhub.groupware.common.entity;

/**
 * ADMIN은 MANAGER를 임명한다.
 */
public enum Role {
    DEVELOPER, // super
    ADMIN,
    // manager, reviewer, approver -> 임원진
    MANAGER,
    REVIEWER,
    APPROVER,
    EMPLOYEE,
    GUEST
}
