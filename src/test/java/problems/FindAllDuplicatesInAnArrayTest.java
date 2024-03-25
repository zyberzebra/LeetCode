package problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllDuplicatesInAnArrayTest {

    public static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(new int[]{4,3,2,7,8,2,3,1}, List.of(2,3)),
                Arguments.of(new int[]{1,1,2}, List.of(1)),
                Arguments.of(new int[]{1}, List.of()),
                Arguments.of(new int[]{}, List.of()),
                Arguments.of(null, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("numbers")
    void findDuplicates(int[] arr, List<Integer> expected) {
        assertThat(FindAllDuplicatesInAnArray.findDuplicates(arr)).isEqualTo(expected);
    }
}