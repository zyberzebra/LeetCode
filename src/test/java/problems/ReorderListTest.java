package problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import problems.helper.ListNode;

import java.util.stream.Stream;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static problems.helper.ListNode.createListNode;

class ReorderListTest {

    static Stream<Arguments> reorderList(){
        return Stream.of(
                arguments(createListNode(of(1,2,3,4)),createListNode(of(1,4,2,3))),
                arguments(createListNode(of(1)),createListNode(of(1))),
                arguments(createListNode(of(1,2)),createListNode(of(1,2))),
                arguments(createListNode(of(1,2,3,4,5)),createListNode(of(1,5,2,4,3)))
        );
    }

    @ParameterizedTest
    @MethodSource("reorderList")
    void reorderList(ListNode head, ListNode expected) {
        assertThat(ReorderList.reorderList(head).toString()).hasToString(expected.toString());
    }
}