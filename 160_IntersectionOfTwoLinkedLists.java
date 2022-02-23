// 815 ms
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode t1 = headA, t2 = headB;
		while (t1 != null) {
			t2 = headB;
			while (t2 != null) {
				if (t1 == t2)
					return t2;
				t2 = t2.next;
			}
			t1 = t1.next;
		}
		return null;
	}
}

// 1 ms
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode a = headA, b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}
}