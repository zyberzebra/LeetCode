package problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2962CountSubarraysWhereMaxElementAppearsatLeastKTimesTest {
    static Stream<Arguments> provideTestData() {
        return Stream.of(
                arguments(new int[]{1,3,2,3,3}, 2, 6),
                arguments(new int[]{1,4,2,1}, 3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxSubarrayLength(int[] nums, int k, int expected) {
        assertThat(P2962CountSubarraysWhereMaxElementAppearsatLeastKTimes.countSubarrays(nums, k)).isEqualTo(expected);
    }
}