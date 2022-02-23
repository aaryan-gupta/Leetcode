/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode temp1 = l1, temp2 = l2, l3 = new ListNode(0);
		ListNode test = l3;
		while (temp1 != null && temp2 != null) {
			if (temp1.val < temp2.val) {
				l3.next = temp1;
				temp1 = temp1.next;
			} else {
				l3.next = temp2;
				temp2 = temp2.next;
			}
			l3 = l3.next;
		}
		if (temp1 != null)
			l3.next = temp1;
		else
			l3.next = temp2;
		return test.next;
	}
}