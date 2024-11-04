package hello.core.beanfind;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextFind1SameBeanTest {

    // 같은 타입이 두 개인 경우
    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시, 같은 타입이 두개 있을 때")
    void findBeanByTypeDuplicate() {
        Assertions.assertThrows(
                NoUniqueBeanDefinitionException.class,
                () -> context.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시, 같은 타입이 두개 있을 때, 빈 이름을 지정하면 된다")
    void findBeanByName() {
        MemberRepository memberRepository = context.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = context.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key=" + key + ", beansOfType=" + beansOfType.get(key));
        }

        System.out.println(beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }
}
