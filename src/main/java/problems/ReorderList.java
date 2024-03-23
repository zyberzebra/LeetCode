package problems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import problems.helper.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/reorder-list/">reorder-list</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReorderList {
    static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        List<ListNode> list = new ArrayList<>();
        int size = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            list.add(curr);
            size++;
        }
        list.forEach(e -> e.next = null);
        int midPoint = size / 2;
        ListNode pointer = head;
        for (int i = 0; i < midPoint; i++) {
            pointer.next = list.get(size-i-1);
            list.get(size-i-1).next = list.get(i + 1);
            pointer = list.get(i+1);
        }
        pointer.next = null;
        return head;
    }
}
