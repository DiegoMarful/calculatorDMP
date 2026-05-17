package com.ciberDMP.calculatorDMP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorDmpApplicationTests {

    private Calculator calculator = new Calculator();

    @Test
    void contextLoads() {
    }

    @Test
    public void testSum() {
        assertEquals(5, calculator.sum(2, 3));
    }
}
