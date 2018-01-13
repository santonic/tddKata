package com.santoni.stringcalculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorInputParser {
    public final static String PREFIX_DELIMITER_SPEC = "//";
    public static final Set<String> DEFAULT_DELIMITERS = Collections.singleton(",");

    boolean areDelimiterProvided(String input) {
        return input.startsWith(PREFIX_DELIMITER_SPEC);
    }

    List<Integer> parseNumbers(String input) {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }

        Collection<String> delimiters;
        String delimiterSeparatedNumbers;

        if (areDelimiterProvided(input)) {
            delimiters = parseDelimiters(input);
            delimiterSeparatedNumbers = parseDelimiterSeparatedNumbers(input, delimiters);
        } else {
            delimiters = new HashSet<>(DEFAULT_DELIMITERS);
            delimiterSeparatedNumbers = input;
        }
        delimiters.add("\n");

        String delimitersPattern = delimiters.stream()
                .map(d->Pattern.quote(d))
                .collect(Collectors.joining("|"));
        return Arrays.stream(delimiterSeparatedNumbers.split(delimitersPattern))
                .mapToInt(n -> Integer.valueOf(n))
                .boxed()
                .collect(Collectors.toList());
    }

    private String parseDelimiterSeparatedNumbers(String input, Collection<String> delimiters) {
        String delimiterSeparatedNumbers;
        int beginNumbers;
        if (delimiters.size() > 1 // several delimiters
            || delimiters.iterator().next().length() > 1 // at least one delimiter, and it is
                ) { // delimiters enclosed in []
            beginNumbers = delimiters.stream().mapToInt(d -> d.length()+2 /* [] */).sum() + 3 /* //\n */;
        } else {
            beginNumbers = 4; // //\n
        }
        delimiterSeparatedNumbers = input.substring(beginNumbers);
        return delimiterSeparatedNumbers;
    }

    private Collection<String> parseDelimiters(String input) {
        String delimitersSpec = input.substring(2, input.indexOf("\n"));

        Pattern delimitersSpecPattern = Pattern.compile("\\[?([^]]+)\\]?");
        Matcher m = delimitersSpecPattern.matcher(delimitersSpec);
        Collection<String> delimiters = new HashSet<>();
        while (m.find()) {
            delimiters.add(m.group(1));
        }
        return delimiters;
    }

}
