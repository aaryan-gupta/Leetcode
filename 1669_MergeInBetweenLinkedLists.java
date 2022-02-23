/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode t1 = list1, t2 = list2, ta = t1, tb = t1;
		for (int i = 0; i < a - 1; i++) {
			ta = t1.next;
			t1 = t1.next;
			// System.out.println(ta.val);
		}

		for (int i = 0; i <= b - a + 1; i++) {
			tb = t1.next;
			t1 = t1.next;
			// System.out.println(tb.val);
		}
		// System.out.println(ta.val);
		// System.out.println(tb.val);
		ta.next = t2;
		while (t2.next != null)
			t2 = t2.next;
		// System.out.println(t2.val);
		t2.next = tb;
		return list1;
	}
}