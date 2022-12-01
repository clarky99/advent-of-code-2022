package com.clarky99.advent2022;

import com.clarky99.advent2022.Solutions.Day1;

public class DriverCode {
    public static void main(String[] args) {
        int maxCaloriesPerElf = Day1.solveOne();
        int totalTopCalories = Day1.solveTwo();
        System.out.println("Answer one:" + maxCaloriesPerElf);
        System.out.println("Answer two:" + totalTopCalories);
    }
}
