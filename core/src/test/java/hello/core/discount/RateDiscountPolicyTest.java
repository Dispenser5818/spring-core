package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    MemberService memberService = new MemberServiceImpl();
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void discount() {

        //given
        Member memberA = new Member(1L,"memberA", Grade.VIP);
        memberService.join(memberA);

        Member memberB = new Member(2L,"memberA", Grade.VIP);
        memberService.join(memberB);

        //when
        int discountA = discountPolicy.discount(memberA,10000);
        int discountB = discountPolicy.discount(memberB,10000);

        //then
        org.assertj.core.api.Assertions.assertThat(discountA).isEqualTo(2000);
        org.assertj.core.api.Assertions.assertThat(discountB).isEqualTo(0);
    }
}