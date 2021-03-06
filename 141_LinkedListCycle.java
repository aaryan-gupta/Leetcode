// 4 ms
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> hs = new HashSet<>();
		while (head != null) {
			if (hs.contains(head))
				return true;
			hs.add(head);
			head = head.next;
		}
		return false;
	}
}

// 0 ms
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
	public boolean hasCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}