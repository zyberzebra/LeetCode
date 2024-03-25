package problems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-duplicates-in-an-array">find-all-duplicates-in-an-array</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FindAllDuplicatesInAnArray {
    static List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                duplicates.add(i);
            }
        }
        return duplicates;
    }


}
