package com.example.advanced.app.v3;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.hellotrace.HelloTraceV2;
import com.example.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderServiceV3;

    private final LogTrace logTrace;

    @GetMapping("/v3/request")
    public String request(String itemId){

        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            orderServiceV3.orderItem(itemId);
            logTrace.end(status);
            return "ok";

        }catch (Exception e){
            logTrace.exception(status, e);
            //예외를 던지지 않으면 정상 흐름으로 동작한다
            //로그는 애플리케이션 흐름에 영향을 주면 안된다.
            throw e;
        }
    }

}
