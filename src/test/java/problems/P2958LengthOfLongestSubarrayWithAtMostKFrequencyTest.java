package problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2958LengthOfLongestSubarrayWithAtMostKFrequencyTest {

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2, 6),
                arguments(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1, 2),
                arguments(new int[]{5, 5, 5, 5, 5, 5, 5}, 4, 4),
                arguments(new int[]{1}, 1, 1),
                arguments(new int[]{2}, 1, 1),
                arguments(new int[]{1, 11}, 2, 2),
                arguments(new int[]{2, 2, 3}, 1, 2),
                arguments(new int[]{8, 8}, 1, 1),
                arguments(new int[]{1, 1, 1, 3}, 2, 3),
                arguments(new int[]{1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                                1000000000, 1000000000}
                        , 5, 5)

        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxSubarrayLength(int[] nums, int k, int expected) {
        assertThat(P2958LengthOfLongestSubarrayWithAtMostKFrequency.maxSubarrayLength(nums, k)).isEqualTo(expected);
    }
}