package com.clarky99.advent2022.Solutions;

import com.clarky99.advent2022.Util.FileReader;

import java.util.*;

public class Day6 {

    public static void main(String[] args) {
        Day6 puzzle = new Day6();
        puzzle.solve();
    }

    private void solve() {
        System.out.println(String.format("Q1 Output: %d", solveOne()));
        System.out.println(String.format("Q2 Output: %d", solveTwo()));
    }

    private int solveOne() {
        String input = FileReader.readFileAsString("Day6.txt");

        for (int i = 0, j = 4; j < input.length(); i++, j++) {
            if (input.substring(i,j).chars().distinct().count() == 4) return j;
        }

        return 1;
    }

    private int solveTwo() {
        String input = FileReader.readFileAsString("Day6.txt");

        for (int i = 0, j = 14; j < input.length(); i++, j++) {
            if (input.substring(i,j).chars().distinct().count() == 14) return j;
        }

        return 1;
    }

}
