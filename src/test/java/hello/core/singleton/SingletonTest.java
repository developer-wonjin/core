package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    void noSpringContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println(memberService1);
        System.out.println(memberService2);

        //isNotSameAs : 주소비교
        //isNotEqualTo: 값(내용물)비교
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("스프링 DI컨테이너")
    void springContainer() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = context.getBean("memberService", MemberService.class);
        MemberService memberService2 = context.getBean("memberService", MemberService.class);

        System.out.println(memberService1);
        System.out.println(memberService2);

        //isNotSameAs : 주소비교
        //isNotEqualTo: 값(내용물)비교
        assertThat(memberService1).isSameAs(memberService2);
    }
}

