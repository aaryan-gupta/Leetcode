// 433 ms
class Node {
	int data;
	Node next;

	Node(int d) {
		this.data = d;
		this.next = null;
	}
}

class MyHashSet {
	Node head;

	/** Initialize your data structure here. */
	public MyHashSet() {
		Node newNode = new Node(-1);
		head = newNode;
	}

	public void add(int key) {
		Node t = head;
		if (!contains(key)) {
			while (t.next != null) {
				t = t.next;
			}
			t.next = new Node(key);
		}
		// System.out.println(key);

		// while(t != null) {
		// System.out.println(t.data);
		// t = t.next;
		// }
	}

	public void remove(int key) {
		if (!contains(key))
			return;
		Node temp = head.next, prev = head;
		while (temp != null) {
			if (temp.data == key)
				break;
			temp = temp.next;
			prev = prev.next;
		}
		prev.next = temp.next;
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		Node temp = head.next;
		while (temp != null) {
			if (temp.data == key)
				return true;
			temp = temp.next;
		}
		return false;
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */

// 9 ms
class MyHashSet {
	boolean[] arr;

	/** Initialize your data structure here. */
	public MyHashSet() {
		arr = new boolean[1000001];
	}

	public void add(int i) {
		arr[i] = true;
	}

	public void remove(int i) {
		arr[i] = false;
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int i) {
		return arr[i];
	}
}