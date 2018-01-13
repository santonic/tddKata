package com.santoni.stringcalculator;

import java.util.List;

public class StringCalculator {
    CalculatorInputParser parser;
    StringCalculatorComputer computer;

    public StringCalculator() {
        this.parser = new CalculatorInputParser();
        this.computer = new StringCalculatorComputer();
    }

    public int add(String input) {
        List<Integer> numbers = parser.parseNumbers(input);
        return computer.computeSum(numbers);
    }

}
