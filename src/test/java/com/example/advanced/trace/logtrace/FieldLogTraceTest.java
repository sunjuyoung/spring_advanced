package com.example.advanced.trace.logtrace;

import com.example.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin(){
        TraceStatus hello = trace.begin("hello");
        TraceStatus hello2 = trace.begin("hello2");
        trace.end(hello2);
        trace.end(hello);

    }

}