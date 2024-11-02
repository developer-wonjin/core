package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig configBean = context.getBean(AppConfig.class);
        System.out.println("ConfigBean = " + configBean);

        MemberServiceImpl memberServiceImpl = context.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderServiceImpl = context.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = context.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberRepository = " + memberServiceImpl.getMemberRepository());
        System.out.println("memberRepository = " + orderServiceImpl.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberServiceImpl.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderServiceImpl.getMemberRepository()).isSameAs(memberRepository);

    }
}
