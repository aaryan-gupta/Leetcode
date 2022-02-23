// 0 ms
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null, next = null, current = head;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
}

// 1 ms
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode reverseList(ListNode head) {
		return helper(head, null, null);
	}

	ListNode helper(ListNode head, ListNode next, ListNode prev) {
		if (head == null)
			return prev;
		next = head.next;
		head.next = prev;
		prev = head;
		head = next;
		return helper(head, next, prev);
	}
}