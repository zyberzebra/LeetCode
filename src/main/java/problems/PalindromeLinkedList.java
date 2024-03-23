package problems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import problems.helper.ListNode;

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

}
