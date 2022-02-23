// 1 ms
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode removeElements(ListNode head, int val) {
		ListNode temp = head;
		while (temp != null && temp.val == val)
			temp = temp.next;
		ListNode current = temp;
		while (current != null && current.next != null) {
			if (current.next.val == val)
				current.next = current.next.next;
			else
				current = current.next;
		}
		return temp;
	}
}

// 1 ms
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode pointer = head;
		while (pointer.next != null) {
			if (pointer.next.val == val)
				pointer.next = pointer.next.next;
			else
				pointer = pointer.next;
		}
		return head.val == val ? head.next : head;
	}
}