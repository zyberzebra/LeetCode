package problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class P992SubarraysWithKDifferentIntegersTest {

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                arguments(new int[]{1,2,1,2,3}, 2, 7),
                arguments(new int[]{1,2,1,3,4}, 3, 3)
        );
    }
    @ParameterizedTest
    @MethodSource("provideTestData")
    void subarraysWithKDistinct(int [] array, int k,int expected) {
        assertThat(P992SubarraysWithKDifferentIntegers.subarraysWithKDistinct(array,k)).isEqualTo(expected);
    }
}