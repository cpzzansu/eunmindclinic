package org.teamhub.groupware.common.repository.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.entity.Status;
import org.teamhub.groupware.common.payload.MemberDto;
import org.teamhub.groupware.common.payload.MemberSearchCondition;
import org.teamhub.groupware.common.payload.QMemberDto;
import org.teamhub.groupware.common.repository.MemberRepositoryCustom;

import java.util.List;
import java.util.Optional;


import static org.springframework.util.StringUtils.hasText;
import static org.teamhub.groupware.common.entity.QMember.member;

public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<MemberDto> findByUsernameAndEmail(String username, String email) {
        return Optional.ofNullable(queryFactory
                .select(new QMemberDto(
                        member.id,
                        member.username,
                        member.password,
                        member.name,
                        member.email,
                        member.tel,
                        member.hp,
                        member.role,
                        member.status,
                        member.createdBy,
                        member.rdate,
                        member.ldate
                ))
                .from(member)
                .where(member.username.eq(username).or(member.email.eq(email)))
                .fetchOne());
    }

    @Override
    public Page<MemberDto> searchMembers(MemberSearchCondition condition, Pageable pageable) {
        BooleanExpression predicate = buildPredicate(condition);

        List<MemberDto> content = queryFactory
                .select(new QMemberDto(
                        member.id,
                        member.username,
                        member.password,
                        member.name,
                        member.email,
                        member.tel,
                        member.hp,
                        member.role,
                        member.status,
                        member.createdBy,
                        member.rdate,
                        member.ldate
                ))
                .from(member)
                .where(predicate)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Member> countQuery = queryFactory
                .select(member)
                .from(member)
                .where(predicate);

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }

    private BooleanExpression buildPredicate(MemberSearchCondition condition) {
        BooleanExpression baseCondition = null;

        if (hasText(condition.getName())) {
            baseCondition = nameEq(condition.getName())
                    .or(telEq(condition.getTel())
                            .or(hpEq(condition.getHp())));
        } else if (hasText(condition.getTel())) {
            baseCondition = telEq(condition.getTel())
                    .or(hpEq(condition.getHp()));
        }

        if (condition.getStatus() != null) {
            if (baseCondition != null) {
                return baseCondition.and(statusEq(condition.getStatus()));
            } else {
                return statusEq(condition.getStatus());
            }
        }

        return baseCondition;
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

    private BooleanExpression statusEq(Status status) {
        return status != null ? member.status.eq(status) : null;
    }

}
