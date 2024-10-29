package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    public void vip_o(){
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discountAmount = discountPolicy.discountAmount(member, 10000);

        // then
        Assertions.assertThat(discountAmount).isEqualTo(1000);
    }

    @Test
    public void vip_x(){
        // given
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);

        // when
        int discountAmount = discountPolicy.discountAmount(member, 10000);

        // then
        Assertions.assertThat(discountAmount).isEqualTo(0);
    }


}