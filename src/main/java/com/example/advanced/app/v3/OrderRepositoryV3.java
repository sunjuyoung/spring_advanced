package com.example.advanced.app.v3;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {


    private final LogTrace logTrace;
    public void save(String itemId){
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.save()");
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
            logTrace.end(status);

        }catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }




    }

    private void sleep(int mill){
        try {
            Thread.sleep(mill);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
