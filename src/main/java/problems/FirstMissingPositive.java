package problems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/first-missing-positive/">first-missing-positive</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FirstMissingPositive {
    static int firstMissingPositive(int[] nums) {
        if(nums == null){
            throw new IllegalArgumentException();
        }
        int smallestPositive = 1;
        int[] sortedNumbers = Arrays.stream(nums).sorted().toArray();
        for (int j : sortedNumbers) {
            if (j == smallestPositive) {
                smallestPositive++;
            }
        }
    return smallestPositive;
    }
}
