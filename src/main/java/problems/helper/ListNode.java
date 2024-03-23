package problems.helper;

import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;


@NoArgsConstructor
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListNode(List<Integer> numbers) {
        List<ListNode> nodes = new LinkedList<>();
        for (int number : numbers) {
                nodes.add(new ListNode(number));
        }
        if (numbers.size() == 1) {
            return nodes.getFirst();
        }
        ListNode iter = new ListNode();
        ListNode pointer = new ListNode(numbers.getFirst(),iter);
        pointer.next = iter;
        for (int i = 1; i < numbers.size(); i++) {
            iter.val = numbers.get(i);
            if (i == numbers.size() - 1 ){
                break;
            }
            iter.next = new ListNode();
            iter = iter.next;
        }
        return pointer;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        sb.append("[");
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append("");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
