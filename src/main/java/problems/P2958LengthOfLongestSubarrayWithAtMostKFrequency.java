package problems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency">length-of-longest-subarray-with-at-most-k-frequency</a>
 * Solved with the help of chatGPT SHAME
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class P2958LengthOfLongestSubarrayWithAtMostKFrequency {
    public static int maxSubarrayLength(int[] nums, int k) {
        int longestGood = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int exceedCount = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            count.put(num, count.getOrDefault(num, 0) + 1);

            if (count.get(num) == k + 1) {
                exceedCount++;
            }

            while (exceedCount > 0) {
                int leftNum = nums[left];
                count.put(leftNum, count.get(leftNum) - 1);
                if (count.get(leftNum) == k) {
                    exceedCount--;
                }
                left++;
            }

            longestGood = Math.max(longestGood, right - left + 1);
        }

        return longestGood;
    }
}
