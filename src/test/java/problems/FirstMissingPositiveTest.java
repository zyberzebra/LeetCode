package problems;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FirstMissingPositiveTest {

    public static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.arguments(new int []{1,2,0},3),
                Arguments.arguments(new int []{3,4,-1,1},2),
                Arguments.arguments(new int []{7,8,9,11,12},1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void firstMissingPositive(int [] input, int expected) {
        assertThat(FirstMissingPositive.firstMissingPositive(input)).isEqualTo(expected);
    }

    @Test
    void nullThrowsIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FirstMissingPositive.firstMissingPositive(null));
    }

}