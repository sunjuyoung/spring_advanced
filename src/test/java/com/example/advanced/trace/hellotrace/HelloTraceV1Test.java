package com.example.advanced.trace.hellotrace;

import com.example.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloTraceV1Test {


    @Test
    void begin_end(){
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus hello = trace.begin("hello");
        trace.end(hello);
    }

    @Test
    void begin_ex(){
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus hello = traceV1.begin("hello");
        traceV1.exception(hello,new IllegalStateException());
    }
}