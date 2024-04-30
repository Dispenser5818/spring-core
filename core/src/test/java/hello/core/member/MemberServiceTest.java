package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {

        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        Member memberB = new Member(2L, "memberB", Grade.VIP);

        //when
        memberService.join(memberA);
        memberService.join(memberB);

        Member findMemberA = memberService.findMember(1L);
        Member findMemberB = memberService.findMember(2L);

        //then
        Assertions.assertThat(memberA).isEqualTo(findMemberA);
        Assertions.assertThat(memberA).isNotEqualTo(findMemberB);

    }

    @Test
    void findMember() {
    }
}