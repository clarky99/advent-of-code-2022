package com.clarky99.advent2022.Solutions;

import com.clarky99.advent2022.Util.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day1 {

    private static final String EOL = "\\r\\n";

    public static int solveOne() {
        List<Integer> elfs = readInput();

        //return elfs.stream().reduce(Integer::max).get();
        // We already have this in order so,
        return elfs.get(0);
    }

    public static int solveTwo() {
        List<Integer> elfs = readInput();

        // return elfs.get(0) + elfs.get(1) + elfs.get(2);
        // or use this cool function
        return IntStream.range(0, 3).map(elfs::get).sum();
    }

    private static List<Integer> readInput() {
        String input = FileReader.readFileAsString("Day1.txt");

        return Arrays.stream(input.split(EOL + EOL))
                .map(elf -> Arrays.stream(elf.split(EOL)).mapToInt(Integer::parseInt).sum())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int maxCaloriesPerElf = Day1.solveOne();
        int totalTopCalories = Day1.solveTwo();
        System.out.println("Answer one:" + maxCaloriesPerElf);
        System.out.println("Answer two:" + totalTopCalories);
    }

}
