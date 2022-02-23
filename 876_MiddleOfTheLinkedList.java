/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode middleNode(ListNode head) {
		ListNode sp = head, dp = head, temp = head;
		while (dp != null && dp.next != null) {
			sp = sp.next;
			dp = dp.next.next;
		}
		return sp;
	}
}