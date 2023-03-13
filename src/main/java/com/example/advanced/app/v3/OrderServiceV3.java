package com.example.advanced.app.v3;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepositoryV3;
    private final LogTrace logTrace;

    public void orderItem(String itemId){

        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");
            orderRepositoryV3.save(itemId);
            logTrace.end(status);

        }catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }

}
