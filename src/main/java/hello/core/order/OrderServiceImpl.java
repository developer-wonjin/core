package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor // @Autowired생략가능함 (생성자 유일할 때)
@Getter
public class OrderServiceImpl implements OrderService {
//    [생성자주입시]
//    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy;

//  [Setter, 일반메소드 주입시]
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

//    [필드주입] <== 쓰지말자!
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

//    [Setter주입]
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

//  [일반메소드주입]
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("OrderServiceImpl init");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // Order객체를 외부에서 직접만든다면 
        // Member객체를 추후 set해주는 작업이 필요한다. 따라서 Order객체가 객체생성초기에 불완전함
        
        // createOrder에서 Member객체까지 준비해서 Order객체를 생성해준다
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discountAmount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


}
