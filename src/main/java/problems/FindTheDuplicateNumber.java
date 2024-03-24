package problems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">find-the-duplicate-number</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FindTheDuplicateNumber {
    static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int keyPosition = -1;
        int counter;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        for (counter = 0; counter < copy.length && keyPosition < 1; counter++) {
            keyPosition = Arrays.binarySearch(copy, counter + 1, copy.length, copy[counter]);
        }
        return noDuplicateFound(keyPosition) ? -1 : copy[--counter];
    }

    private static boolean noDuplicateFound(int keyPosition) {
        return keyPosition < 1;
    }
}
