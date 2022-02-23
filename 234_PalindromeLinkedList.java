/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head, fast = head, temp = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = reverseList(slow);
		fast = head;
		while (slow != null) {
			if (slow.val != fast.val)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}

	public ListNode reverseList(ListNode head) {
		ListNode temp = head, prev = null, next = null;
		while (temp != null) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		return prev;
	}
}