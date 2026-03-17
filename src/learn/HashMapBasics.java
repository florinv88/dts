package learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HashMapBasics {

    public static void main(String[] args) {
        //ex1
        countNumberAppearance(new int[]{3, 7, 3, 9, 3, 7});

        //ex2
        System.out.println(Arrays.toString(twoSum(new int[]{3, 7, 1, 9, 2}, 8)));

        //ex3
        System.out.println(Arrays.toString(treeSum(new int[]{3, 7, 1, 9, 2}, 11)));

        //ex4
        System.out.println(hasDifferenceOfK(new int[]{1, 5, 3, 9}, 2));

        //ex5
        System.out.println(Arrays.toString(pairWithMaximumSum(new int[]{1, 5, 3, 9, 2})));
    }

    /*
     * EX1: Count how many times each number appears
     * Input: [3, 7, 3, 9, 3, 7]
     */

    public static void countNumberAppearance(int[] numbers) {
        HashMap<Integer, Integer> appearances = new HashMap<>();

        for (int i = 0; i <= numbers.length - 1; i++) {
            if (appearances.containsKey(numbers[i])) {
                appearances.put(numbers[i], appearances.get(numbers[i]) + 1);
            } else {
                appearances.put(numbers[i], 1);
            }
        }

        for (Integer key : appearances.keySet()) {
            System.out.println(key + " appeared " + appearances.get(key) + " times");
        }
    }

    /*
     * EX2: THE FAMOUS TWO SUM PROBLEM!
     * PROBLEM: Find two numbers that add up to a target (their indexes)
     */

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> seenNumbers = new HashMap<>();
        for (int i = 0; i <= numbers.length - 1; i++) {
            var complement = target - numbers[i];
            if (seenNumbers.containsKey(complement)) {
                return new int[]{seenNumbers.get(complement), i};
            } else {
                seenNumbers.put(numbers[i], i);
            }
        }
        return new int[]{};
    }

    /*
     * EX2: TREE SUM
     * PROBLEM: Find 3 numbers that add up to a target (their indexes)
     */

    public static int[] treeSum(int[] numbers, int target) {
        for (int i = 0; i <= numbers.length - 1; i++) {
            var remaining = target - numbers[i];

            HashMap<Integer, Integer> seenNumbers = new HashMap<>();
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                var complement = remaining - numbers[j];
                if (seenNumbers.containsKey(complement)) {
                    return new int[]{i, seenNumbers.get(complement), j};
                } else {
                    seenNumbers.put(numbers[j], j);
                }
            }
        }
        return new int[]{};
    }

    /*
     * EX3:
     * MEDIUM: Find if any two numbers have a difference of k
     *    Input: [1, 5, 3, 9], k = 2
     *    Output: true (because 5 - 3 = 2)
     */

    public static boolean hasDifferenceOfK(int[] numbers, int k) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (seenNumbers.contains(numbers[i] - k)) {
                return true;
            }
            seenNumbers.add(numbers[i]);
        }
        return false;
    }

    /*
     * EX3:
     * MEDIUM: Find pair with maximum sum
     *    Input: [1, 5, 3, 9, 2]
     *    Output: [5, 9] (because 5 + 9 = 14 is the max)
     */

    public static int[] pairWithMaximumSum(int[] numbers){
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int i = 0; i <= numbers.length - 1; i++) {
            seenNumbers.add(numbers[i]);
        }
        int[] array = seenNumbers.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
        return new int[]{array[array.length - 1], array[array.length - 2]};
    }

    public static int[] pairWithMaximumSum2(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{};
        }

        int first  = Math.max(numbers[0], numbers[1]);
        int second = Math.min(numbers[0], numbers[1]);

        for (int i = 2; i < numbers.length; i++) {
            int n = numbers[i];
            if (n > first) {
                second = first;
                first = n;
            } else if (n > second) {
                second = n;
            }
        }

        return new int[]{first, second};
    }
}
