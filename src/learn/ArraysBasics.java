package learn;

import java.util.Arrays;

public class ArraysBasics {

    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, 9, 2};
        //ex1
        System.out.println(findBiggestNumberIn(numbers));

        //ex2
        System.out.println(isNumberIn(7, numbers));

        //ex3
        System.out.println(countAppearancesForNumber(3, new int[]{3, 7, 3, 9, 3}));

        //ex4
        System.out.println(Arrays.toString(reverse1(numbers)));
        System.out.println(Arrays.toString(reverse2(numbers)));

        //ex5
        System.out.println(isAscSorted(numbers));
    }

    /*
     * EXERCISE 1: Find the biggest number in an array
     * PROBLEM: Given [3, 7, 1, 9, 2], find the biggest number (9)
     */

    public static int findBiggestNumberIn(int[] numbers) {
        int biggest = numbers[0];
        for (int i = 1; i <= numbers.length - 1; i++) {
            if (numbers[i] > biggest) {
                biggest = numbers[i];
            }
        }
        return biggest;
    }

    /*
     * EXERCISE 2: Find a specific number in an array
     * PROBLEM: Is the number 7 in the array [3, 7, 1, 9, 2]?
     */

    public static boolean isNumberIn(int target, int[] numbers) {
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] == target) {
                return true;
            }
        }
        return false;
    }

    /*
     * EXERCISE 3: Count how many times a number appears
     * PROBLEM: In [3, 7, 3, 9, 3], how many times does 3 appear?
     */

    public static int countAppearancesForNumber(int target, int[] numbers) {
        int count = 0;
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] == target) {
                count++;
            }
        }
        return count;
    }

    /*
     * EXERCISE 4: Reverse an array
     * PROBLEM: Reverse [3, 7, 1, 9, 2] to get [2, 9, 1, 7, 3]
     */

    public static int[] reverse1(int[] numbers) {
        //new array and copy elements from last to first
        int[] reversed = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            reversed[numbers.length - 1 - i] = numbers[i];
        }
        return reversed;
    }

    public static int[] reverse2(int[] numbers) {
        int pointer1 = 0;
        int pointer2 = numbers.length - 1;

        while (pointer1 < pointer2) {
            int temp = numbers[pointer1];
            numbers[pointer1] = numbers[pointer2];
            numbers[pointer2] = temp;
            pointer1++;
            pointer2--;
        }
        return numbers;
    }

    /*
     * EXERCISE 5: Check if an array is SORTED
     */

    public static boolean isAscSorted(int[] numbers) {
        for (int i = 0; i <= numbers.length - 2; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }
}