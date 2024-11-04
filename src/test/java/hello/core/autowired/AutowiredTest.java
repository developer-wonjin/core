package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    static class SomeBean {

        // Member는 스프링Bean이 아님!!

        @Autowired(required = false)
        public void setter1(Member member) {
            // 호출안됨
            System.out.println("setter1 = " + member);
        }

        @Autowired
        public void setter2(@Nullable Member member) {
            System.out.println("setter2 = " + member);
        }

        @Autowired
        public void setter3(Optional<Member> member) {
            System.out.println("setter3 = " + member);
        }
    }

    @Test
    void AutowiredTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SomeBean.class);
        SomeBean someBean = context.getBean(SomeBean.class);

    }
}
