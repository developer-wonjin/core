package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 자동구성
@Configuration
@ComponentScan(
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    public AutoAppConfig() {
        System.out.println("AutoAppConfig의 생성자호출");
    }

//    수동구성 (OrderServiceImpl클래스에 @Component를 제거한 상황이 전제돼야함)
//    @Bean
//    OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        System.out.println("AutoAppConfig.orderService");
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }

    // [수동빈등록]
    // 자동등록 된 빈과 충돌이 발생하지 않으며 아래 수동등록 빈으로 덮어써짐
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        System.out.println("AutoAppConfig의 memberRepository");
//        return new MemoryMemberRepository();
//    }
}