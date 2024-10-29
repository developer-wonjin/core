package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discountAmount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
