package memberManage;

import memberManage.domain.entity.Member;
import memberManage.domain.repository.MemberRepositoryImpl;
import memberManage.service.MemberService;
import memberManage.service.MemberServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService;
    MemberRepositoryImpl memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemberRepositoryImpl();
        memberService = new MemberServiceImpl(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("JaeAn");

        int savedId = memberService.join(member);

        Member target = memberService.findOne(savedId);

        Assertions.assertTrue(member.equalsTo(target));
    }

    @Test
    void duplicateNameException() {
        Member member1 = new Member();
        member1.setName("JaeAn2");

        Member member2 = new Member();
        member2.setName("JaeAn2");

        String expectedErrorMsg = member2.getName() + "는 이미 존재하는 회원입니다.";

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () ->
            memberService.join(member2)
        );

        assertEquals(e.getMessage(), expectedErrorMsg);
    }
}