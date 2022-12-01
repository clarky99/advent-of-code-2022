package com.clarky99.advent2022.Solutions;

import com.clarky99.advent2022.Util.FileReader;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    public static int solveOne() {
        List<List<Integer>> inputs = readInput();
        return inputs.stream()
                .map(p -> p.stream().reduce(0, Integer::sum))
                .mapToInt(p -> p)
                .max()
                .getAsInt();
    }

    public static int solveTwo() {
        List<List<Integer>> inputs = readInput();
        List<Integer> integers = inputs.stream()
                .map(p -> p.stream().reduce(0, Integer::sum))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return integers.get(0) + integers.get(1) + integers.get(2);
    }

    private static List<List<Integer>> readInput() {
        String input = FileReader.readFileAsString("Day1.txt");
        String[] items = input.split("\r\n\r\n");

        return Arrays.stream(items)
                .map(p -> Arrays.stream(p.split("\r\n")).map(Integer::valueOf).collect(Collectors.toList())).collect(Collectors.toList());
    }

}
