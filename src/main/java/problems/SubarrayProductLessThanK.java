package problems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <a href="https://leetcode.com/problems/subarray-product-less-than-k">subarray-product-less-than-k</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubarrayProductLessThanK {
    static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null){
            throw new IllegalArgumentException("nums is null");
        }
        if (nums.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                result++;
                result += calculatePossibleSubarrayProductsLessThanK(nums, k, i);
            }
        }
        return result;
    }

    private static int calculatePossibleSubarrayProductsLessThanK(int[] nums, int k, int i) {
        int subResult = 0;
        int subarrayProduct = nums[i];
        for (int j = i + 1; j < nums.length; j++) {
            if (subarrayProduct * nums[j] >= k) {
                break;
            }
            subResult++;
            subarrayProduct = subarrayProduct * nums[j];
        }
        return subResult;
    }
}
