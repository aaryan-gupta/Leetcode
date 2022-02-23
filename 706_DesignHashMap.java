// 616 ms
class MyHashMap {
	List<Integer> l1, l2;

	/** Initialize your data structure here. */
	public MyHashMap() {
		l1 = new ArrayList<>();
		l2 = new ArrayList<>();
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		if (l1.contains(key))
			l2.set(l1.indexOf(key), value);
		else {
			l1.add(key);
			l2.add(value);
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		if (l1.contains(key))
			return l2.get(l1.indexOf(key));
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		if (l1.contains(key)) {
			int i = l1.indexOf(key);
			l1.remove(i);
			l2.remove(i);
		}
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */

// ========================================================

// 28 ms
class MyHashMap {

	class ListNode {
		final int key;
		int val;
		ListNode next;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	final int SIZE = 10001;
	ListNode[] array;

	/** Initialize your data structure here. */
	public MyHashMap() {
		array = new ListNode[SIZE];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int index = hash(key);
		ListNode head = array[index];
		ListNode node = head;
		while (node != null) {
			if (node.key == key) {
				node.val = value;
				return;
			}
			node = node.next;
		}
		// note, head might be null, so always add to the head
		ListNode newNode = new ListNode(key, value);
		newNode.next = head;
		array[index] = newNode;
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int index = hash(key);
		ListNode node = array[index];
		while (node != null) {
			if (node.key == key)
				return node.val;
			node = node.next;
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int index = hash(key);
		ListNode node = array[index];
		while (node != null) {
			if (node.key == key) {
				node.val = -1;
				return;
			}
			node = node.next;
		}
	}

	private int hash(int key) {
		return key % SIZE;
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */