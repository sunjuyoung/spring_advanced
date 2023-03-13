package com.example.advanced.trace.hellotrace;

import com.example.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloTraceV2Test {


    @Test
    void begin_end(){
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        TraceStatus status1 = trace.beginSync(status.getTraceId(), "hello2");
        trace.end(status1);
        trace.end(status);
    }

    @Test
    void begin_ex(){
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus hello = traceV1.begin("hello");
        traceV1.exception(hello,new IllegalStateException());
    }
}