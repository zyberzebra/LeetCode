package problems;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SubarrayProductLessThanKTest {


    static Stream<Arguments> provideTestData() {
        return Stream.of(
                arguments(new int[] {10,5,2,6},100,8),
                arguments(new int[] {1,2,3},0,0),
                arguments(new int[] {1,1,1},1,0),
                arguments(new int[] {},100,0),
                arguments(new int[] {1,2,3},-100,0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void numSubarrayProductLessThanK(int[] nums, int k, int expected) {
        assertThat(SubarrayProductLessThanK.numSubarrayProductLessThanK(nums,k)).isEqualTo(expected);
    }
    @Test
    void nullThrowsException() {
        assertThatExceptionOfType(IllegalArgumentException.class).
                isThrownBy(() -> SubarrayProductLessThanK.numSubarrayProductLessThanK(null,1337));
    }
}