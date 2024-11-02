package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
//    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    AnnotationConfigApplicationContext acCxt
        = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] beanDefinitionNames = acCxt.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = acCxt.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName + ", bean=" + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findAppBean() {
        String[] beanDefinitionNames = acCxt.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = acCxt.getBeanDefinition(beanDefinitionName);

            // {ROLE_APPLICATION, ROLE_SUPPORT, ROLE_INFRASTRUCTURE}
            if (beanDefinition.getRole() != BeanDefinition.ROLE_APPLICATION) continue;

            Object bean = acCxt.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName + ", bean=" + bean);
        }
    }


}

/*
모든빈출력
11:41:00.350 [main] DEBUG o.s.c.a.AnnotationConfigApplicationContext -- Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@402c4085
11:41:00.382 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
11:41:00.647 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerProcessor'
11:41:00.663 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'
11:41:00.663 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
11:41:00.663 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
11:41:00.678 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'appConfig'
11:41:00.694 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'memberService'
11:41:00.694 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'memberRepository'
11:41:00.694 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'orderService'
11:41:00.694 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'discountPolicy'
name=org.springframework.context.annotation.internalConfigurationAnnotationProcessor, bean=org.springframework.context.annotation.ConfigurationClassPostProcessor@40c80397
name=org.springframework.context.annotation.internalAutowiredAnnotationProcessor, bean=org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@4b672daa
name=org.springframework.context.annotation.internalCommonAnnotationProcessor, bean=org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@ea9b7c6
name=org.springframework.context.event.internalEventListenerProcessor, bean=org.springframework.context.event.EventListenerMethodProcessor@e077866
name=org.springframework.context.event.internalEventListenerFactory, bean=org.springframework.context.event.DefaultEventListenerFactory@ed3068a
name=appConfig, bean=hello.core.AppConfig$$SpringCGLIB$$0@7c2b6087
name=memberService, bean=hello.core.member.MemberServiceImpl@3fffff43
name=orderService, bean=hello.core.order.OrderServiceImpl@a8e6492
name=memberRepository, bean=hello.core.member.MemoryRepository@1c7fd41f
name=discountPolicy, bean=hello.core.discount.RateDiscountPolicy@3b77a04f

Process finished with exit code 0

 */

/*

C:\jdk-17.0.11\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.4\lib\idea_rt.jar=55611:C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.4\lib\idea_rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.4\plugins\junit\lib\junit5-rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.4\plugins\junit\lib\junit-rt.jar;C:\Users\eh\Desktop\Source\core\out\test\classes;C:\Users\eh\Desktop\Source\core\out\production\classes;C:\Users\eh\Desktop\Source\core\out\production\resources;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework.boot\spring-boot-starter-test\3.3.5\b4b61da11affe88867c452b3b2c5277cb50b209\spring-boot-starter-test-3.3.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework.boot\spring-boot-starter\3.3.5\16b7a9acf1918a8f763e871ada3794e9ffd4a980\spring-boot-starter-3.3.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.projectlombok\lombok\1.18.34\ec547ef414ab1d2c040118fb9c1c265ada63af14\lombok-1.18.34.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework.boot\spring-boot-test-autoconfigure\3.3.5\c70d4805d5f0a39476326cf3e0dbfcf57d861c8d\spring-boot-test-autoconfigure-3.3.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework.boot\spring-boot-test\3.3.5\91db886b7a202ae6f5a597f871b0c832ee1f78b3\spring-boot-test-3.3.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework\spring-test\6.1.14\8fbac6fc57f6ca7b429fb02b7aa3caea7e1a281d\spring-test-6.1.14.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework\spring-core\6.1.14\45d2d808015bf6c5411e457fa09e843042dc3a76\spring-core-6.1.14.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\com.jayway.jsonpath\json-path\2.9.0\37fe2217f577b0b68b18e62c4d17a8858ecf9b69\json-path-2.9.0.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\jakarta.xml.bind\jakarta.xml.bind-api\4.0.2\6cd5a999b834b63238005b7144136379dc36cad2\jakarta.xml.bind-api-4.0.2.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\net.minidev\json-smart\2.5.1\4c11d2808d009132dfbbf947ebf37de6bf266c8e\json-smart-2.5.1.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.assertj\assertj-core\3.25.3\792b270e73aa1cfc28fa135be0b95e69ea451432\assertj-core-3.25.3.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.awaitility\awaitility\4.2.2\7336242073ebf83fe034e42b46a403c5501b63c9\awaitility-4.2.2.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.hamcrest\hamcrest\2.2\1820c0968dba3a11a1b30669bb1f01978a91dedc\hamcrest-2.2.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter\5.10.5\cbf98926c44240c9ca1519a20e58722be6d6a44a\junit-jupiter-5.10.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.mockito\mockito-junit-jupiter\5.11.0\8e658dd339f40305ed4293db25545b5df98b171b\mockito-junit-jupiter-5.11.0.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.mockito\mockito-core\5.11.0\e4069fa4f4ff2c94322cfec5f2e45341c6c70aff\mockito-core-5.11.0.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.skyscreamer\jsonassert\1.5.3\aaa43e0823d2a0e106e8754d6a9c4ab24e05e9bc\jsonassert-1.5.3.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.xmlunit\xmlunit-core\2.9.1\e5833662d9a1279a37da3ef6f62a1da29fcd68c4\xmlunit-core-2.9.1.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework.boot\spring-boot-autoconfigure\3.3.5\1efbbd46eeef054986796200313f4bb0d53a7268\spring-boot-autoconfigure-3.3.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework.boot\spring-boot\3.3.5\1a0d1dc425d445503bd01c9aa3683aaebc524e3b\spring-boot-3.3.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework.boot\spring-boot-starter-logging\3.3.5\de318d4baa64f02631accf51d708e906b304b4cc\spring-boot-starter-logging-3.3.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\jakarta.annotation\jakarta.annotation-api\2.1.1\48b9bda22b091b1f48b13af03fe36db3be6e1ae3\jakarta.annotation-api-2.1.1.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.yaml\snakeyaml\2.2\3af797a25458550a16bf89acc8e4ab2b7f2bfce0\snakeyaml-2.2.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework\spring-jcl\6.1.14\842b2b24a375efd79af436860d22ba4e0082ff4b\spring-jcl-6.1.14.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\jakarta.activation\jakarta.activation-api\2.1.3\fa165bd70cda600368eee31555222776a46b881f\jakarta.activation-api-2.1.3.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\net.minidev\accessors-smart\2.5.1\19b820261eb2e7de7d5bde11d1c06e4501dd7e5f\accessors-smart-2.5.1.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\net.bytebuddy\byte-buddy\1.14.19\4c0c637b8f47dc08f89240e6f59900011752c97b\byte-buddy-1.14.19.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-params\5.10.5\e19d95e190aedb81c883d50cc05b1860400d957c\junit-jupiter-params-5.10.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-api\5.10.5\a5c09855b0087daaddaa5faa5100ab2555d5e111\junit-jupiter-api-5.10.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\net.bytebuddy\byte-buddy-agent\1.14.19\154da3a65b4f4a909d3e5bdec55d1b2b4cbb6ce1\byte-buddy-agent-1.14.19.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\com.vaadin.external.google\android-json\0.0.20131108.vaadin1\fa26d351fe62a6a17f5cda1287c1c6110dec413f\android-json-0.0.20131108.vaadin1.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework\spring-context\6.1.14\b3d96fb4310376a608465c3544b7cfb790293787\spring-context-6.1.14.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\ch.qos.logback\logback-classic\1.5.11\c4473fb51fea6682ad477cf3c2206b8b9623b9d8\logback-classic-1.5.11.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.apache.logging.log4j\log4j-to-slf4j\2.23.1\425ad1eb8a39904d2830e907a324e956fb456520\log4j-to-slf4j-2.23.1.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.slf4j\jul-to-slf4j\2.0.16\6d57da3e961daac65bcca0dd3def6cd11e48a24a\jul-to-slf4j-2.0.16.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm\9.6\aa205cf0a06dbd8e04ece91c0b37c3f5d567546a\asm-9.6.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.apiguardian\apiguardian-api\1.1.2\a231e0d844d2721b0fa1b238006d15c6ded6842a\apiguardian-api-1.1.2.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-commons\1.10.5\6d1985c5eece30fb9faafe9bf1f5e005ac3d0fcc\junit-platform-commons-1.10.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.opentest4j\opentest4j\1.3.0\152ea56b3a72f655d4fd677fc0ef2596c3dd5e6e\opentest4j-1.3.0.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework\spring-aop\6.1.14\3d5002d4c415c1ff4720f214c804d3d7e7d10111\spring-aop-6.1.14.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework\spring-beans\6.1.14\be71b919145e20fb7f38c81467d7d0f1c09ad1bd\spring-beans-6.1.14.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.springframework\spring-expression\6.1.14\495646d4968fb90aa97bc05a7d298d0c32898a1d\spring-expression-6.1.14.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\io.micrometer\micrometer-observation\1.13.6\8650b5372db17587f1271cd130beafa93d7eb573\micrometer-observation-1.13.6.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\ch.qos.logback\logback-core\1.5.11\727bdb8dc75b6c392f9be56224503948abc248e8\logback-core-1.5.11.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.slf4j\slf4j-api\2.0.16\172931663a09a1fa515567af5fbef00897d3c04\slf4j-api-2.0.16.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.apache.logging.log4j\log4j-api\2.23.1\9c15c29c526d9c6783049c0a77722693c66706e1\log4j-api-2.23.1.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\io.micrometer\micrometer-commons\1.13.6\224f398df08315a8f9cda21fcb4f062d24da4a49\micrometer-commons-1.13.6.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-launcher\1.10.5\3b16b91a447cf687c968ee23d21827534fdac5a2\junit-platform-launcher-1.10.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-engine\1.10.5\7db4b98a955a2686d893a8a209591f029c438b44\junit-platform-engine-1.10.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-engine\5.10.5\e234785788419ffdfc4b65474b2081c0a9f7e77d\junit-jupiter-engine-5.10.5.jar;C:\Users\eh\.gradle\caches\modules-2\files-2.1\org.objenesis\objenesis\3.3\1049c09f1de4331e8193e579448d0916d75b7631\objenesis-3.3.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 hello.core.beanfind.ApplicationContextInfoTest,findAppBean
11:48:49.742 [main] DEBUG o.s.c.a.AnnotationConfigApplicationContext -- Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@6fa51cd4
11:48:49.773 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
11:48:50.070 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerProcessor'
11:48:50.086 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'
11:48:50.086 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
11:48:50.101 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
11:48:50.117 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'appConfig'
11:48:50.133 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'memberService'
11:48:50.133 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'memberRepository'
11:48:50.133 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'orderService'
11:48:50.133 [main] DEBUG o.s.b.f.s.DefaultListableBeanFactory -- Creating shared instance of singleton bean 'discountPolicy'
name=appConfig, bean=hello.core.AppConfig$$SpringCGLIB$$0@4b672daa
name=memberService, bean=hello.core.member.MemberServiceImpl@ea9b7c6
name=orderService, bean=hello.core.order.OrderServiceImpl@e077866
name=memberRepository, bean=hello.core.member.MemoryRepository@ed3068a
name=discountPolicy, bean=hello.core.discount.RateDiscountPolicy@7c2b6087

Process finished with exit code 0


 */