package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmout = 1000;

    @Override
    public int discountAmount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)return discountFixAmout;
        return 0;
    }
}