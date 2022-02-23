// 71 ms => Backtracking + Trie

class Solution {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, res);
			}
		}
		return res;
	}

	public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		char c = board[i][j];
		if (c == '#' || p.next[c - 'a'] == null)
			return;
		p = p.next[c - 'a'];
		if (p.word != null) { // found one
			res.add(p.word);
			p.word = null; // de-duplicate
		}

		board[i][j] = '#';
		if (i > 0)
			dfs(board, i - 1, j, p, res);
		if (j > 0)
			dfs(board, i, j - 1, p, res);
		if (i < board.length - 1)
			dfs(board, i + 1, j, p, res);
		if (j < board[0].length - 1)
			dfs(board, i, j + 1, p, res);
		board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode p = root;
			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (p.next[i] == null)
					p.next[i] = new TrieNode();
				p = p.next[i];
			}
			p.word = w;
		}
		return root;
	}

	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
}

// ========================================================

// 1450 ms => Backtracking + DFS

class Solution {
	public List<String> findWords(char[][] board, String[] words) {
		int r = board.length;
		int c = board[0].length;
		Set<String> result = new HashSet<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for (String word : words) {
					if (board[i][j] == word.charAt(0) && dfs(board, word, new boolean[r][c], i, j, 0)) {
						result.add(word);
					}
				}
			}
		}
		return new ArrayList<>(result);
	}

	private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
		if (word.length() == index)
			return true;

		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j]
				|| board[i][j] != word.charAt(index))
			return false;

		visited[i][j] = true;

		if (dfs(board, word, visited, i + 1, j, index + 1) || dfs(board, word, visited, i - 1, j, index + 1)
				|| dfs(board, word, visited, i, j + 1, index + 1) || dfs(board, word, visited, i, j - 1, index + 1))
			return true;

		visited[i][j] = false;

		return false;
	}
}

// ========================================================

// 93 ms => Trie + DFS

class Solution {

	List<String> res;
	char[][] board;

	public List<String> findWords(char[][] _board, String[] words) {
		res = new ArrayList<String>();
		this.board = _board;
		TrieNode trie = new TrieNode();
		trie.constructTrie(words);
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				helper(r, c, trie);
			}
		}
		Collections.sort(res);
		return res;
	}

	private void helper(int r, int c, TrieNode trie) {
		if (r < 0 || c < 0 || r == board.length || c == board[r].length || board[r][c] == '#')
			return;
		char currentChar = board[r][c];
		TrieNode next = trie.children[currentChar - 'a'];
		if (next == null)
			return;
		if (!next.word.equals("")) {
			res.add(next.word);
			next.word = "";
		}
		board[r][c] = '#';
		helper(r + 1, c, next);
		helper(r - 1, c, next);
		helper(r, c + 1, next);
		helper(r, c - 1, next);
		board[r][c] = currentChar;
	}

	class TrieNode {

		TrieNode[] children = new TrieNode['z' - 'a' + 1];
		String word = "";

		public void constructTrie(String[] words) {
			TrieNode current = this;
			for (String word : words) {
				for (char c : word.toCharArray()) {
					if (current.children[c - 'a'] == null) {
						current.children[c - 'a'] = new TrieNode();
					}
					current = current.children[c - 'a'];
				}
				current.word = word;
				current = this;
			}
		}

	}
}

// ========================================================

// 1052 ms => String

class Solution {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList();
		for (String word : words)
			if (exist(board, word))
				res.add(word);
		return res;
	}

	public boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && existWord(board, word, i, j, 1))
					return true;
			}
		return false;
	}

	private boolean existWord(char[][] board, String word, int row, int col, int index) {
		if (index == word.length())
			return true;
		board[row][col] = '.';
		if (row > 0 && board[row - 1][col] == word.charAt(index) && existWord(board, word, row - 1, col, index + 1)) {
			board[row][col] = word.charAt(index - 1);
			return true;
		}
		if (row < board.length - 1 && board[row + 1][col] == word.charAt(index)
				&& existWord(board, word, row + 1, col, index + 1)) {
			board[row][col] = word.charAt(index - 1);
			return true;
		}
		if (col > 0 && board[row][col - 1] == word.charAt(index) && existWord(board, word, row, col - 1, index + 1)) {
			board[row][col] = word.charAt(index - 1);
			return true;
		}
		if (col < board[0].length - 1 && board[row][col + 1] == word.charAt(index)
				&& existWord(board, word, row, col + 1, index + 1)) {
			board[row][col] = word.charAt(index - 1);
			return true;
		}
		board[row][col] = word.charAt(index - 1);
		return false;
	}
}