/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		int n = k;
		ListNode current = head, prev = null;
		while (n > 0 && current != null) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			n--;
		}
		if (n > 0)
			prev = reverseKGroup(prev, k - n);
		if (current != null)
			head.next = reverseKGroup(current, k);
		return prev;
	}
}