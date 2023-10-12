package org.teamhub.groupware.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.teamhub.groupware.common.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>, MemberRepositoryCustom, QuerydslPredicateExecutor {

}
