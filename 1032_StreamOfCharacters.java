class StreamChecker {
	class Trie {
		Trie[] tries;
		boolean isEnding;

		public Trie() {
			tries = new Trie[26];
			isEnding = false;
		}
	}

	StringBuilder sb;
	Trie parent;

	public StreamChecker(String[] words) {
		sb = new StringBuilder();
		parent = new Trie();
		for (String s : words) {
			Trie root = parent;
			for (int i = s.length() - 1; i >= 0; i--) {
				if (root.tries[s.charAt(i) - 'a'] == null)
					root.tries[s.charAt(i) - 'a'] = new Trie();
				root = root.tries[s.charAt(i) - 'a'];
			}
			root.isEnding = true;
		}
	}

	public boolean query(char letter) {
		sb.append(letter);
		Trie root = parent;
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (root.tries[sb.charAt(i) - 'a'] == null)
				return false;
			if (root.tries[sb.charAt(i) - 'a'].isEnding)
				return true;
			root = root.tries[sb.charAt(i) - 'a'];
		}
		return false;
	}
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */