/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode temp = head.next;
		head.next = swapPairs(head.next.next);
		temp.next = head;
		return temp;
	}
}

// ============================

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p1 = head, p2 = p1.next, p3 = p2.next;
		p1.next = p3;
		p2.next = p1;
		if (p3 != null)
			p1.next = swapPairs(p3);
		return p2;
	}
}

// ======================================

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode current = head, next = null, prev = null;
		int c = 0;
		while (current != null && c < 2) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			c++;
		}
		if (next != null)
			head.next = swapPairs(next);
		return prev;
	}
}