package com.clarky99.advent2022.Solutions;

import com.clarky99.advent2022.Util.FileReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day2 {

    // a x - rock 1
    // b y - paper 2
    // c z - scissors 3
    // win - 6
    // loss - 0
    // tie - 3
    private final Map<String, Integer> points = Map.of(
            "A X", 4,
            "A Y", 8,
            "A Z", 3,
            "B X", 1,
            "B Y", 5,
            "B Z", 9,
            "C X", 7,
            "C Y", 2,
            "C Z", 6
            );

    private final Map<String, String> strategies = Map.of(
            "A X", "A Z",
            "A Y", "A X",
            "A Z", "A Y",
            "B X", "B X",
            "B Y", "B Y",
            "B Z", "B Z",
            "C X", "C Y",
            "C Y", "C Z",
            "C Z", "C X"
    );
    // q1 12535
    // q2 15457
    private static final String EOL = "\\r\\n";

    private int solve1refactor() {
        String s = FileReader.readFileAsString("Day2.txt");

        return Arrays.stream(s.split(EOL)).map(
                points::get
        ).reduce(0,Integer::sum);
    }

    private int solve2refactor() {
        String s = FileReader.readFileAsString("Day2.txt");

        return Arrays.stream(s.split(EOL)).map(
                p -> points.get(strategies.get(p))
        ).reduce(0,Integer::sum);
    }

    public static void main(String[] args) {
        Day2 puzzle = new Day2();
        puzzle.solve();
    }

    private void solve() {
        System.out.println(String.format("Q2 Output: %d", solve1refactor()));
        System.out.println(String.format("Q2 Output: %d", solve2refactor()));
    }

    private int solveTwo() {
        String s = FileReader.readFileAsString("Day2.txt");
        Map<String, Integer> points = new HashMap<>();
        points.put("X",0); // lose
        points.put("Y",3); // draw
        points.put("Z",6); // win
        points.put("A",1);
        points.put("B",2);
        points.put("C",3);

        return Arrays.stream(s.split(EOL)).map(
                p -> {
                    String[] inputs = p.split(" ");
                    int elfInput = points.get(inputs[0]);
                    int myCondition = points.get(inputs[1]);
                    int myInput;

                    if (myCondition == 6) myInput = elfInput > 2 ? 1 : elfInput + 1; // win
                    else if (myCondition == 3) myInput = elfInput;
                    else myInput = elfInput == 1 ? 3 : elfInput - 1;

                    return myCondition + myInput;
                }
        ).reduce(0,Integer::sum);
    }

    private Integer readData() {
        String s = FileReader.readFileAsString("Day2.txt");
        //x -rock
        //y - paper
        //z - scissors
        //a - rock 1 pt
        //b - paper 2 pt
        //c - scissors 3 pt

        //loss - 0 pt
        //tie - 3 pt
        //win - 6 pt
        Map<String, Integer> points = new HashMap<>();
        points.put("X",1);
        points.put("Y",2);
        points.put("Z",3);
        points.put("A",1);
        points.put("B",2);
        points.put("C",3);

        return Arrays.stream(s.split(EOL)).map(
                p -> {
                    String[] inputs = p.split(" ");
                    int elfInput = points.get(inputs[0]);
                    int myInput = points.get(inputs[1]);
                    if (elfInput == myInput) {
                        return 3 + myInput;
                    }
                    if (elfInput == 1) {
                        if (myInput == 2) return 6 + myInput;
                    }
                    if (elfInput == 2) {
                        if (myInput == 3) return 6 + myInput;
                    }
                    else {
                        if (myInput == 1) return 6 + myInput;
                    }
                    return myInput;
                }
        ).reduce(0,Integer::sum);



    }

}
