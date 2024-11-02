package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextFind2ExtendsBeanTest {

    // 같은 타입이 두 개인 경우
    @Configuration
    static class ExtendsBeanConfig {
        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }
    }

    AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(ExtendsBeanConfig.class);

    @Test
    @DisplayName("부모타입으로 조회시, 자식이 둘 이상")
    void findBeanByParentDuplicate() {
        Assertions.assertThrows(
                NoUniqueBeanDefinitionException.class,
                () -> context.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모타입으로 조회시, 자식이 둘 이상, 빈 이름을 지정하면 된다")
    void findBeanByName() {
        DiscountPolicy rateDiscountPolicy = context.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 타입의 하위를 모두 조회하기")
    void findAllBeanByType() {
        Map<String, DiscountPolicy> beansOfType = context.getBeansOfType(DiscountPolicy.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key=" + key + ", beansOfType=" + beansOfType.get(key));
        }

        System.out.println(beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }


}
