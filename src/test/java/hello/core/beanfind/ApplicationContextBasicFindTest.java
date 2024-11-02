package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;


public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AppConfig.class // 명시안하면 has not been refreshed yet 에러남
    );

//    MemberService memberService = context.getBean("memberService", MemberService.class);
//    MemberService memberService = context.getBean(                 MemberService.class);
//    MemberService memberService = context.getBean("memberService", MemberServiceImpl.class);
    @Test
    @DisplayName("{빈이름+타입}으로 조회")
    void findBeanByName() {
        MemberService memberService = context.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("{타입}으로만 조회")
    void findBeanByType() {
        MemberService memberService = context.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("{빈이름+구체타입}으로 조회")//유연하지 못함
    void findBeanByName2() {
        MemberService memberService = context.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("{빈이름+타입}으로 조회가 안될 때")//유연하지 못함
    void findBeanByNameX() {
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> {
            context.getBean("abcde", MemberServiceImpl.class);
        });
    }

}
