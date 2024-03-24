package problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindTheDuplicateNumberTest {

    public static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.arguments(new int []{1,3,4,2,2},2),
                Arguments.arguments(new int []{3,1,3,4,2},3),
                Arguments.arguments(new int []{3,3,3,3,3},3),
                Arguments.arguments(new int []{1,3,4,2,1},1),
                Arguments.arguments(new int []{1,2},-1),
                Arguments.arguments(new int []{},-1),
                Arguments.arguments(null,-1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void findDuplicate(int [] arr, int expected) {
        assertThat(FindTheDuplicateNumber.findDuplicate(arr)).isEqualTo(expected);
    }
}