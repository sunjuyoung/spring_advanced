package com.example.advanced.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
public class FieldService {

    private String nameStore;


    public String logic(String name){
        log.info("저장 name ={} --> nameStore={}",name,nameStore);
        nameStore = name;
        sleep(1000);
        log.info("조회 nameStore={}",nameStore);
        return nameStore;
    }


    private void sleep(int mill){
        try {
            Thread.sleep(mill);
        }catch (InterruptedException e){

        }

    }

}
