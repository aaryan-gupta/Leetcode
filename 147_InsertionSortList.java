// 3 ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode insertionSortList(ListNode head) {
		ListNode temp = head;
		ArrayList<Integer> l = new ArrayList<>();
		while (temp != null) {
			l.add(temp.val);
			temp = temp.next;
		}
		Collections.sort(l);
		int i = 0;
		temp = head;
		while (temp != null) {
			temp.val = l.get(i++);
			temp = temp.next;
		}
		return head;
	}
}

// ======================================================

// 10 ms

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode preInsert;
		ListNode toInsert;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode currIt = head;
		while (currIt != null && currIt.next != null) {
			if (currIt.val <= currIt.next.val)
				currIt = currIt.next;
			else {
				toInsert = currIt.next;
				preInsert = dummyHead;
				while (preInsert.next.val < toInsert.val) {
					preInsert = preInsert.next;
				}
				currIt.next = toInsert.next;
				toInsert.next = preInsert.next;
				preInsert.next = toInsert;
			}
		}
		return dummyHead.next;
	}
}