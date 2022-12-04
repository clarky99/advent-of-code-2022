package com.clarky99.advent2022.Solutions;

import com.clarky99.advent2022.Util.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day3 {
    private static final String EOL = "\\r\\n";
    private static final String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Day3 puzzle = new Day3();
        puzzle.solve();
    }

    private void solve() {
        System.out.println(String.format("Q1 Output: %d", solveOne()));
        System.out.println(String.format("Q2 Output: %d", solveTwo()));
    }

    private int solveOne() {
        // a-z 1-26
        // A-Z 27-52
        List<String> s = List.of(FileReader.readFileAsString("Day3.txt").split(EOL));

        return s.stream().map(p -> {
            String[] parts = splitInHalf(p);
            HashSet<Character> seen = new HashSet<>();
            HashSet<Character> seen2 = new HashSet<>();

            for (char c : parts[0].toCharArray()) seen.add(c);
            for (char c : parts[1].toCharArray()) seen2.add(c);
            seen.retainAll(seen2);

            return seen.stream().map(this::getCharValue).reduce(0, Integer::sum);
        }).reduce(0,Integer::sum);
    }

    private int solveTwo() {
        List<String> s = List.of(FileReader.readFileAsString("Day3.txt").split(EOL));
        List<List<String>> bucketList = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < s.size(); i ++) {
            temp.add(s.get(i));
            counter += 1;
            if (counter > 2) {
                // push temp and reset
                bucketList.add(temp);
                temp = new ArrayList<>();
                counter = 0;
            }
        }

        return bucketList.stream().map(item -> {
            HashSet<Character> seen = new HashSet<>();
            HashSet<Character> seen2 = new HashSet<>();
            HashSet<Character> seen3 = new HashSet<>();
            for (char c : item.get(0).toCharArray()) seen.add(c);
            for (char c : item.get(1).toCharArray()) seen2.add(c);
            for (char c : item.get(2).toCharArray()) seen3.add(c);

            seen.retainAll(seen2);
            seen.retainAll(seen3);

            return seen.stream().map(this::getCharValue).reduce(0, Integer::sum);
        }).reduce(0,Integer::sum);
    }

    private int getCharValue(char c) {

        return letters.indexOf(c) + 1;
    }

    private String[] splitInHalf(String s) {

        final int mid = s.length() / 2; //get the middle of the String
        return new String[]{s.substring(0, mid), s.substring(mid)};
    }
}
