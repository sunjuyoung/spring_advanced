package com.example.advanced.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {


    private FieldService fieldService= new FieldService();
    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    void field(){
        log.info("main start");
        Runnable userA =() ->{
            threadLocalService.logic("userA");
        };
        Runnable userB =() ->{
            threadLocalService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-a");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-b");

        threadA.start();
       // sleep(2000);
        threadB.start();

        sleep(2000);
        log.info("main exit");
    }

    private void sleep(int mill){
        try {
            Thread.sleep(mill);
        }catch (InterruptedException e){

        }

    }
}
