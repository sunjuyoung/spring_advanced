package com.example.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.view.AbstractTemplateView;

@Slf4j
public class TemplateMethodTest {

    @Test
    void test1(){
        logic1();
        logic2();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);

    }
    private void logic2(){
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);

    }
    @Test
    void templateMethod1(){

        AbstractTemplate abstractTemplate = new SubClassLogic1();
        AbstractTemplate abstractTemplate2 = new SubClassLogic2();

        abstractTemplate.execute();
        abstractTemplate2.execute();
    }

    @Test
    void templateMethod2(){
        AbstractTemplate abstractTemplate = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1");
            }
        };
        abstractTemplate.execute();

    }



}
