package com.clarky99.advent2022.Solutions;

import com.clarky99.advent2022.Util.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Day5 {

    private static final String EOL = "\\r\\n";

    public static void main(String[] args) {
        Day5 puzzle = new Day5();
        puzzle.solve();
    }

    private void solve() {
        System.out.println(String.format("Q1 Output: %s", solveOne()));
        System.out.println(String.format("Q2 Output: %s", solveTwo()));
    }

    private String solveOne() {
        List<Stack<Character>> stacks = Arrays.stream(FileReader.readFileAsString("Day5Crates.txt").split(EOL)).map(
                p -> {
                    Stack<Character> stack = new Stack<>();
                    char[] chars = p.toCharArray();
                    for (char c : chars) stack.push(c);
                    return stack;
                }
        ).collect(Collectors.toList());


        FileReader.readFileAsString("Day5.txt").split(EOL);

        for (String p : FileReader.readFileAsString("Day5.txt").split(EOL)) {
            String[] s = p.split(" ");
            // 1, 3 ,5
            int operationCount = Integer.parseInt(s[1]);
            int fromIndex = Integer.parseInt((s[3])) - 1;
            int toIndex = Integer.parseInt((s[5])) - 1;
            for (int i = 0; i < operationCount; i++) {
                char temp = stacks.get(fromIndex).pop();
                stacks.get(toIndex).push(temp);
            }
        }
        return stacks.stream().map(Stack::pop).map(String::valueOf).collect(Collectors.joining());
    }
    private String solveTwo() {
        List<Stack<Character>> stacks = Arrays.stream(FileReader.readFileAsString("Day5Crates.txt").split(EOL)).map(
                p -> {
                    Stack<Character> stack = new Stack<>();
                    char[] chars = p.toCharArray();
                    for (char c : chars) stack.push(c);
                    return stack;
                }
        ).collect(Collectors.toList());


        FileReader.readFileAsString("Day5.txt").split(EOL);

        for (String p : FileReader.readFileAsString("Day5.txt").split(EOL)) {
            String[] s = p.split(" ");
            // 1, 3 ,5
            int operationCount = Integer.parseInt(s[1]);
            int fromIndex = Integer.parseInt((s[3])) - 1;
            int toIndex = Integer.parseInt((s[5])) - 1;

            List<Character> temp = new ArrayList<>();
            for (int i = 0; i < operationCount; i++) {
                temp.add(stacks.get(fromIndex).pop());
            }
            for (int i = temp.size() - 1; i >= 0; i--) {
                stacks.get(toIndex).push(temp.get(i));
            }


        }
        return stacks.stream().map(Stack::pop).map(String::valueOf).collect(Collectors.joining());
    }
}
