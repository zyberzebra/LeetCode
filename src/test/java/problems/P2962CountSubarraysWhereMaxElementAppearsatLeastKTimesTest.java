package problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2962CountSubarraysWhereMaxElementAppearsatLeastKTimesTest {
    static Stream<Arguments> provideTestData() throws IOException {
        return Stream.of(
                arguments(new int[]{1, 3, 2, 3, 3}, 2, 6),
                arguments(new int[]{1, 4, 2, 1}, 3, 0),
                arguments(Arrays.stream(Files.readAllLines(Paths.get("src/test/resources/P2962Testdata"), Charset.defaultCharset()).get(0).split(","))
                        .mapToInt(Integer::valueOf).toArray(), 6282, 2815068166L)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxSubarrayLength(int[] nums, int k, long expected) {
        assertThat(P2962CountSubarraysWhereMaxElementAppearsatLeastKTimes.countSubarrays(nums, k)).isEqualTo(expected);
    }
}