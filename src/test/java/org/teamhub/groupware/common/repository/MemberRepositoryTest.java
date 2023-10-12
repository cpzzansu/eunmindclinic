package org.teamhub.groupware.common.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.teamhub.groupware.common.entity.Member;
import org.teamhub.groupware.common.mapper.MemberMapper;
import org.teamhub.groupware.common.payload.MemberDto;
import org.teamhub.groupware.common.payload.MemberSearchCondition;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    public void setup() {
        MemberDto memberDto = MemberDto.builder()
                .id("admin")
                .groupId("")
                .refId("")
                .country("미국")
                .password("password")
                .passwordIO("passwordIO")
                .company("123")
                .name("이규노")
                .email("ctccts22@gmail.com")
                .tel("010-1111-1111")
                .hp("02-111-1111")
                .level(1)
                .status(99)
                .rdate(LocalDateTime.now())
                .ldate(LocalDateTime.now())
                .build();
        Member member = MemberMapper.toEntity(memberDto);
        Member savedMember = memberRepository.save(member);
        assertThat(savedMember).isNotNull();

        em.flush();
    }

    @DisplayName("Junit test for search member operation")
    @Test
    public void givenAdminSearchMemberObject_whenSelectMemberWithDynamicQuery_thenReturnAdminMember() {
        //given
        MemberSearchCondition condition = new MemberSearchCondition();
        condition.setCompany("123123"); // searching by company name
        condition.setName("이규노"); // searching by member name
        condition.setTel("010-1111-1111"); // searching by telephone number
        PageRequest pageRequest = PageRequest.of(0, 10);
        // when
        Page<MemberDto> result = memberRepository.searchMembers(condition, pageRequest);

        assertThat(result.getSize()).isEqualTo(10);
        assertThat(result.getTotalElements()).isEqualTo(1);

    }
}
