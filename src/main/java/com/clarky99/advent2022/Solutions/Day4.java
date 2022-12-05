package com.clarky99.advent2022.Solutions;

import com.clarky99.advent2022.Util.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    private static final String EOL = "\\r\\n";

    public static void main(String[] args) {
        Day4 puzzle = new Day4();
        puzzle.solve();
    }

    private void solve() {
        System.out.println(String.format("Q1 Output: %d", solveOne()));
        System.out.println(String.format("Q2 Output: %d", solveTwo()));
    }

    private int solveOne() {
        List<String> s = Arrays.stream(FileReader.readFileAsString("Day4.txt").split(EOL)).collect(Collectors.toList());

        return s.stream().map(p -> {
            String[] ranges = p.split(",");
            String[] range1 = ranges[0].split("-");
            String[] range2 = ranges[1].split("-");

            if(Integer.parseInt(range1[0]) >= Integer.parseInt(range2[0]) && Integer.parseInt(range1[1]) <= Integer.parseInt(range2[1])) return 1;
            if(Integer.parseInt(range2[0]) >= Integer.parseInt(range1[0]) && Integer.parseInt(range2[1]) <= Integer.parseInt(range1[1])) return 1;
            return 0;
        }).reduce(0,Integer::sum);
    }

    private int solveTwo() {
        List<String> s = Arrays.stream(FileReader.readFileAsString("Day4.txt").split(EOL)).collect(Collectors.toList());

        return s.stream().map(p -> {
            String[] ranges = p.split(",");
            String[] range1 = ranges[0].split("-");
            String[] range2 = ranges[1].split("-");

            int leftLow = Integer.parseInt(range1[0]);
            int leftHigh = Integer.parseInt(range1[1]);
            int rightLow = Integer.parseInt(range2[0]);
            int rightHigh = Integer.parseInt(range2[1]);

            if (leftLow <= rightHigh && leftHigh >= rightLow) {
                return 1;
            }

            return 0;
        }).reduce(0,Integer::sum);
    }
}
