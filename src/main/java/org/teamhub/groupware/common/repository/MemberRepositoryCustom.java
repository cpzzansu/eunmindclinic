package org.teamhub.groupware.common.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.payload.MemberDto;
import org.teamhub.groupware.common.payload.MemberSearchCondition;

import java.util.List;
import java.util.Optional;


public interface MemberRepositoryCustom {

    Optional<MemberDto> findByUsernameAndEmail(String username, String email);

    Page<MemberDto> searchMembers(MemberSearchCondition memberSearchCondition, Pageable pageable);

    Optional<MemberDto> findByUsername(String username);

    Optional<MemberDto> findByEmail(String email);
}
