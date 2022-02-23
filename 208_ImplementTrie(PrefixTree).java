class Trie {
	private class Node {
		char value;
		boolean isEnd;
		HashMap<Character, Node> children = new HashMap<>();

		Node(char val) {
			value = val;
		}
	}
	// public Trie() {

	// }

	private Node root = new Node(' ');

	public void insert(String word) {
		Node current = root;
		for (char ch : word.toCharArray()) {
			if (!current.children.containsKey(ch))
				current.children.put(ch, new Node(ch));
			current = current.children.get(ch);
		}
		current.isEnd = true;
	}

	public boolean search(String word) {
		Node current = root;
		for (char ch : word.toCharArray()) {
			if (current == null || !current.children.containsKey(ch))
				return false;
			current = current.children.get(ch);
		}
		return current.isEnd;
	}

	public boolean startsWith(String prefix) {
		Node current = root;
		for (char ch : prefix.toCharArray()) {
			if (current == null || !current.children.containsKey(ch))
				return false;
			current = current.children.get(ch);
		}
		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */

// ===========================================

class Trie {
	private TrieNode root;

	private class TrieNode {
		private TrieNode[] children = null;
		private boolean isWord = false;

		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode it = root;
		for (char ch : word.toCharArray()) {
			int indexInTrieNode = ch - 'a';
			if (it.children[indexInTrieNode] == null)
				it.children[indexInTrieNode] = new TrieNode();
			it = it.children[indexInTrieNode];
		}
		it.isWord = true;
	}

	public boolean search(String word) {
		TrieNode it = root;
		for (char ch : word.toCharArray()) {
			int indexInTrieNode = ch - 'a';
			if (it.children[indexInTrieNode] == null)
				return false;
			else
				it = it.children[indexInTrieNode];
		}
		return it.isWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode it = root;
		for (char ch : prefix.toCharArray()) {
			int indexInTrieNode = ch - 'a';
			if (it.children[indexInTrieNode] == null)
				return false;
			else
				it = it.children[indexInTrieNode];
		}
		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */