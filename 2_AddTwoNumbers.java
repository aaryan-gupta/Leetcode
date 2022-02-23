// RECURSIVE APPROACH
class Solution {
	int carry = 0;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null && carry == 0)
			return null;
		int val1 = l1 == null ? 0 : l1.val;
		int val2 = l2 == null ? 0 : l2.val;
		int sum = val1 + val2 + carry;
		carry = sum / 10;
		l1 = l1 == null ? null : l1.next;
		l2 = l2 == null ? null : l2.next;
		ListNode ans = new ListNode(sum % 10, addTwoNumbers(l1, l2));
		return ans;
	}
}

// ITERATIVE APPROACH
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode t1 = l1, t2 = l2, l3 = new ListNode(0);
		ListNode temp = l3;
		int x = 0, y = 0, carry = 0, sum = 0;
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
		return l3.next;
	}
}