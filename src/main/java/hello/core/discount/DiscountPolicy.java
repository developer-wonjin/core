package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @param member 주문고객
     * @param price 상품금액
     * @return 할인금액을 리턴
     */
    int discountAmount(Member member, int price);
}
