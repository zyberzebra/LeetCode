package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/count-subarrays-where-max-element-appears-at-least-k-times">
 *     count-subarrays-where-max-element-appears-at-least-k-times</a>
 */
public class P2962CountSubarraysWhereMaxElementAppearsatLeastKTimes {
   static long countSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
       int max = Arrays.stream(nums).max().orElse(0);
       Map<Integer, Integer> longLongMap = new HashMap<>();
       longLongMap.put(max, 0);
       while (left < nums.length) {
           while (right < nums.length) {
               longLongMap.put(nums[right], longLongMap.getOrDefault(nums[right], 0) + 1);
               if (longLongMap.getOrDefault(max,0) >= k) {
                   count++;
               }
               right++;
           }
           left++;
           right = left;
           longLongMap.clear();
       }
       return count;
    }
}
