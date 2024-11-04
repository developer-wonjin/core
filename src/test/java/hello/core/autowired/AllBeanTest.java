package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    static class DiscountSerivce {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DiscountSerivce(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }

        public int discount(Member member, int price, String fixDiscountPolicy) {
            DiscountPolicy discountPolicy = policyMap.get(fixDiscountPolicy);
            return discountPolicy.discountAmount(member, price);
        }
    }

    @Test
    void findALlBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountSerivce.class);
        DiscountSerivce discountSerivce = context.getBean(DiscountSerivce.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountSerivce.discount(member, 20000, "fix");

        assertThat(discountSerivce).isInstanceOf(DiscountSerivce.class);
        assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountSerivce.discount(member, 20000, "rate");
        assertThat(rateDiscountPrice).isEqualTo(2000);
    }
}
