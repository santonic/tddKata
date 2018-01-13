package com.santoni.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class CalculatorInputParserTest {
    CalculatorInputParser parser = new CalculatorInputParser();

    @Test
    public void parseEmptyString() throws Exception {
        Assert.assertEquals(Collections.emptyList(), parser.parseNumbers(""));
    }

    @Test
    public void parseNumberList() throws Exception {
        Assert.assertEquals(Arrays.asList(3, 2, 4, 6, 5, 8), parser.parseNumbers("3,2,4,6,5,8"));
    }

    @Test
    public void parseNegativeNumberList() throws Exception {
        Assert.assertEquals(Arrays.asList(-8), parser.parseNumbers("-8"));
    }

    @Test
    public void parseNumberListWithNewLines() throws Exception {
        Assert.assertEquals(Arrays.asList(3, 2), parser.parseNumbers("3\n2"));
    }

    @Test
    public void parseNumberAllowsToChangeDelimiter() throws Exception {
        Assert.assertEquals(Arrays.asList(1, 2), parser.parseNumbers("//;\n1;2"));
    }

    @Test
    public void parseAllowsToUseLongDelimiters() throws Exception {
        Assert.assertEquals(Arrays.asList(1, 2, 3), parser.parseNumbers("//[***]\n1***2***3"));
    }

    @Test
    public void parseAllowsToUseMultipleDelimiters() throws Exception {
        Assert.assertEquals(Arrays.asList(1, 2, 3), parser.parseNumbers("//[*][%]\n1*2%3"));
    }

    @Test
    public void parseAllowsToUseMultipleMulticharDelimiters() throws Exception {
        Assert.assertEquals(Arrays.asList(1, 2, 3), parser.parseNumbers("//[**][%%]\n1**2%%3"));
    }

}