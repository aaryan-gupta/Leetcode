/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode swapNodes(ListNode head, int k) {
		ListNode fast = head, slow = head, first = head, second = head;
		for (int i = 0; i < k - 1; i++)
			fast = fast.next;
		first = fast;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		second = slow;
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
		return head;
	}
}

// =====================================

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
	public ListNode swapNodes(ListNode head, int k) {
		ListNode temp = head, s = head, f = head;
		int c = 0;
		while (temp != null) {
			c++;
			if (c == k)
				s = temp;
			temp = temp.next;
		}
		int r = 0;
		while (r < c - k) {
			f = f.next;
			r++;
		}
		int t = s.val;
		s.val = f.val;
		f.val = t;
		return head;
	}
}
