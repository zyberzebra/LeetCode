package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/count-subarrays-where-max-element-appears-at-least-k-times">
 * count-subarrays-where-max-element-appears-at-least-k-times</a>
 */
public class P2962CountSubarraysWhereMaxElementAppearsatLeastKTimes {
    static long countSubarrays(int[] nums, int k) {
        int left = 0;
        long count = 0;
        long max = Arrays.stream(nums).max().orElse(0);
        Map<Long, Long> longLongMap = new HashMap<>();
        longLongMap.put(max, 0L);

        for (int right = 0; right < nums.length; right++) {
            longLongMap.put((long)nums[right], longLongMap.getOrDefault((long)nums[right], 0L) + 1);

            while (left <= right && longLongMap.getOrDefault(max, 0L) >= k) {
                count += nums.length - right;
                longLongMap.put((long)nums[left], longLongMap.get((long)nums[left]) - 1);
                left++;
            }
        }
        return count;
    }
}
