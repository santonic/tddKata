package com.santoni.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzNumberPrinterTest {

    private final FizzBuzzNumberPrinter printer = new FizzBuzzNumberPrinter();

    // Print the numbers from 1 to 100.
    // But for multiples of three, print "Fizz” instead of the number
    // and for the multiples of five, print "Buzz".
    // For numbers which are multiples of both three and five, print "FizzBuzz".
    @Test
    public void printNormalNumber() {
        Assert.assertEquals("4", printer.print(4));
    }

    @Test
    public void printMultiplesOfThreeNumber() {
        Assert.assertEquals("Fizz", printer.print(6));
    }

    @Test
    public void printMultiplesOfFiveNumber() {
        Assert.assertEquals("Buzz", printer.print(10));
    }

    @Test
    public void printMultiplesOfFiveAndThreeNumber() {
        Assert.assertEquals("FizzBuzz", printer.print(15));
    }


}
