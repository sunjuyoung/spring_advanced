package com.example.advanced.app.v1;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderServiceV1;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(String itemId){

        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderServiceV1.orderItem(itemId);
            trace.end(status);
            return "ok";

        }catch (Exception e){
            trace.exception(status, e);
            //예외를 던지지 않으면 정상 흐름으로 동작한다
            //로그는 애플리케이션 흐름에 영향을 주면 안된다.
            throw e;
        }
    }

}
