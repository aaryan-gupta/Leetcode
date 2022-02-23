/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode t1 = l1, t2 = l2, l3 = new ListNode(0);
		ListNode temp = l3;
		int x = 0, y = 0, carry = 0, sum = 0;
		t1 = reverse(t1);
		t2 = reverse(t2);
		while (t1 != null || t2 != null) {
			x = t1 == null ? 0 : t1.val;
			y = t2 == null ? 0 : t2.val;
			sum = carry + x + y;
			carry = sum / 10;
			temp.next = new ListNode(sum % 10);
			temp = temp.next;
			if (t1 != null)
				t1 = t1.next;
			if (t2 != null)
				t2 = t2.next;
		}
		if (carry > 0)
			temp.next = new ListNode(carry);
		return reverse(l3.next);
	}

	public ListNode reverse(ListNode head) {
		ListNode current = head, next = null, prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}