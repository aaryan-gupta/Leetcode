// 2 ms
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		if (head.next == null)
			return null;
		ListNode temp = head, fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		if (fast == null)
			return head.next;
		fast = fast.next;
		while (fast != null) {
			temp = temp.next;
			fast = fast.next;
		}
		// if(temp.next != null) {
		// temp.val = temp.next.val;
		temp.next = temp.next.next;
		// }
		System.out.println(temp.val);
		return head;
	}
}

// 0 ms
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int c = 0;
		ListNode temp = head;
		while (temp != null) {
			c++;
			temp = temp.next;
		}
		temp = head;
		for (int i = 0; i < c - n - 1; i++)
			temp = temp.next;
		if (c - n == 0)
			head = head.next;
		else
			temp.next = temp.next.next;
		return head;
	}
}