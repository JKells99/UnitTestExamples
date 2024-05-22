package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    Calculator calculator = new Calculator();

    @Test
    public void testInjection(){
        Assertions.assertEquals(calculator != null);
    }

    @Test
    @DisplayName("Test For Adding")
    public void testAdd(){
        Assertions.assertEquals(5,calculator.add(2,3));
        Assertions.assertEquals(-1,calculator.add(-2,1));

    }

    @Test
    public void testMultiply(){
        Assertions.assertEquals(6,calculator.multiply(2,3));
        Assertions.assertEquals(10,calculator.multiply(2,5));

    }

    @Test
    public void testDivideByZero() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(1, 0);
        });
        Assertions.assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testAddingException(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            calculator.add(0,0);
        });
        Assertions.assertEquals("0 + 0 is Nothing",exception.getMessage());
    }


}
