package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = context.getBean(MemberService.class);
        OrderServiceImpl OrderServiceImpl = context.getBean(OrderServiceImpl.class);

        System.out.println("memberService: " + memberService);
        System.out.println("orderService: " + OrderServiceImpl);
        System.out.println("orderService.getDiscountPolicy: " + OrderServiceImpl.getDiscountPolicy());
        System.out.println("orderService.getMemberRepository: " + OrderServiceImpl.getMemberRepository());

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
