package problems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">palindrome-linked-list</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class PalindromeLinkedList {
    static boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        List<Integer> list = new LinkedList<>();
        for (ListNode temp = head; temp != null; temp = temp.next) {
            list.add(temp.val);
        }
        return list.reversed().equals(list);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return next != null ? val + next.toString() : String.valueOf(val);
        }
    }
}
