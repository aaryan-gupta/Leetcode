/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public int getDecimalValue(ListNode head) {
		ListNode temp = reverse(head);
		int i = 0;
		int ans = 0;
		while (temp != null) {
			ans += temp.val * 1 << i;
			// ans = 1 << i;
			i++;
			// System.out.println(temp.val + " " + ans);
			temp = temp.next;
		}
		return ans;
	}

	static ListNode reverse(ListNode head) {
		ListNode curr = head, prev = null, next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}