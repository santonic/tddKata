package com.santoni.stringcalculator;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;

public class StringCalculatorComputerTest {
    StringCalculatorComputer computer = new StringCalculatorComputer();

    @Test
    public void computeSumFromEmptyListReturns0() throws Exception {
        Assert.assertEquals(0, computer.computeSum(Arrays.asList()));
    }

    @Test
    public void computeSumReturnsTheirSum() throws Exception {
        Assert.assertEquals(28, computer.computeSum(Arrays.asList(3,2,4,6,5,8)));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addThrowsExceptionIfNegativeNumbersArePresent() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(containsString("Negative arguments: -3 and -2"));
        computer.computeSum(Arrays.asList(-3,1,-2));
    }

    @Test
    public void addIgnoresNumberGreaterThan1000() throws Exception {
        Assert.assertEquals(2, computer.computeSum(Arrays.asList(1001,2)));
    }

}
