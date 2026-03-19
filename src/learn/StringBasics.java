package learn;

import java.util.HashMap;

public class StringBasics {

    public static void main(String[] args) {
        System.out.println(checkAnagrams("hello", "world"));
        System.out.println(checkAnagramFastest("hello", "world"));
        System.out.println(maxSumOfK(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20}, 4));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /*
     * PROBLEM: Are two strings anagrams?
     *
     * Anagram = same letters, different order
     *
     * Examples:
     * "listen" and "silent"→ TRUE (same letters)
     * "hello" and "world"→ FALSE (different letters)
     *
     */

    public static boolean checkAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> mapFroStr1 = new HashMap<>();
        HashMap<Character, Integer> mapFroStr2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (mapFroStr1.containsKey(str1.charAt(i))) {
                mapFroStr1.put(str1.charAt(i), mapFroStr1.get(str1.charAt(i)) + 1);
            } else {
                mapFroStr1.put(str1.charAt(i), 1);
            }

            if (mapFroStr2.containsKey(str2.charAt(i))) {
                mapFroStr2.put(str2.charAt(i), mapFroStr1.get(str2.charAt(i)) + 1);
            } else {
                mapFroStr2.put(str2.charAt(i), 1);
            }
        }

        return mapFroStr1.equals(mapFroStr2);
    }

    public static boolean checkAnagramFastest(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] count = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }


    /*
     * What is Sliding Window?
     *
     * Think of looking through a window that slides along the string:
     *
     * "abcdef"
     *  [abc]    ← window of size 3
     *   [bcd]   ← slide right
     *    [cde]  ← slide right
     *     [def] ← slide right
     *
     * Used when you need to check substrings or subarrays!
     */

    /*
     * PROBLEM: Maximum sum of k consecutive numbers
     *
     * Input: [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
     * Question: What's the max sum of 4 consecutive numbers?
     *
     * Answer: 39 (10 + 23 + 3 + 1)
     *
     * THE SLOW WAY: Calculate sum for each window from scratch
     * [1,4,2,10] = 17
     * [4,2,10,23] = 39
     * [2,10,23,3] = 38
     * ... keep recalculating
     *
     * THE SMART WAY: Slide the window!
     * [1,4,2,10] = 17
     * Remove 1, add 23: 17 - 1 + 23 = 39
     * Remove 4, add 3: 39 - 4 + 3 = 38
     * ... just subtract and add!
     */

    public static int maxSumOfK(int[] numbers, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += numbers[i];
        }
        //maxSum = sum of the first k
        for (int i = k; i < numbers.length; i++) {
            int newSum = maxSum - numbers[i - k] + numbers[i];
            maxSum = Math.max(maxSum, newSum);
        }
        return maxSum;
    }

    /*
       PROBLEM: Longest Substring Without Repeating Characters
     * Input: "abcabcbb"
     * Output: 3 (because "abc" is the longest without repeats)
     */

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Map: character → most recent index where it appeared
        HashMap<Character, Integer> lastSeen = new HashMap<>();

        int maxLength = 0;
        int left = 0;   // start of current window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If we have seen this character before AND it appeared inside current window
            if (lastSeen.containsKey(currentChar) && lastSeen.get(currentChar) >= left) {
                // Move left pointer to right after the last occurrence
                left = lastSeen.get(currentChar) + 1;
            }

            // Update the last seen index of this character
            lastSeen.put(currentChar, right);

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
