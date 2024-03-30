package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/subarrays-with-k-different-integers">
 * subarrays-with-k-different-integers</a>
 */
public class P992SubarraysWithKDifferentIntegers {

    static int subarraysWithKDistinct(int[] nums, int k) {
        int left = 0;
        int goodArrays = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (left < nums.length) {
            int right = left;
            while (right < nums.length) {
                map.clear();
                for (int i = left; i <= right; i++) {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                }

                long distinctValues = map.keySet().size();
                if (distinctValues == k) {
                    goodArrays++;
                }
                right++;
            }
            left++;
        }

        return goodArrays;
    }
}
