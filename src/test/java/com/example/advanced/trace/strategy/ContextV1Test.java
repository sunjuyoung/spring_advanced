package com.example.advanced.trace.strategy;

import com.example.advanced.trace.strategy.code.ContextV1;
import com.example.advanced.trace.strategy.code.Strategy;
import com.example.advanced.trace.strategy.code.StrategyLogic1;
import com.example.advanced.trace.template.AbstractTemplate;
import com.example.advanced.trace.template.SubClassLogic1;
import com.example.advanced.trace.template.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

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
    void strategy1(){
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

    }

    @Test
    void strategy2(){
        Strategy strategy = new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 1실행");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategy);
        contextV1.execute();
    }




}
