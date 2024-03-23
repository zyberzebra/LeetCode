package problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import problems.helper.ListNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class PalindromeLinkedListTest {

    static Stream<Arguments> palindromeSource() {
        return Stream.of(
                arguments(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))),
                arguments(new ListNode(1, new ListNode(1))),
                arguments(new ListNode(1))
        );
    }

    @ParameterizedTest
    @MethodSource("palindromeSource")
    void detectValidPalindrome(ListNode input) {
        assertThat(PalindromeLinkedList.isPalindrome(input)).isTrue();
    }

    static Stream<Arguments> noPalindromeSource() {
        return Stream.of(
                arguments(new ListNode(1, new ListNode(2)))
        );
    }

    @ParameterizedTest
    @MethodSource("noPalindromeSource")
    @NullSource
    void detectInvalidPalindrome(ListNode input) {
        assertThat(PalindromeLinkedList.isPalindrome(input)).isFalse();
    }

}