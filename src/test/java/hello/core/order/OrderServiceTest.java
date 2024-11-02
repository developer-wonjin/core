package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();

    }
    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }

    @Test
    @DisplayName("필드주입 테스트")
    void fieldInjectionTest() {
        
        //스프링Bean이 아닌 내가 직접만든 레포지토리객체
//        MemberRepository memberRepository = new MemoryRepository();
//        MemberServiceImpl memberService = new MemberServiceImpl(memberRepository);
//        memberService.join(new Member(1L, "memberA", Grade.VIP));
        
//        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        
        // 내가 직접만든 레포지토리 객체를 설정해주고 싶을 때
//        orderServiceImpl.setMemberRepository(memberRepository);
//        orderServiceImpl.setDiscountPolicy(new FixDiscountPolicy());
//        orderServiceImpl.createOrder(1L, "itemA", 20000);
    }
}