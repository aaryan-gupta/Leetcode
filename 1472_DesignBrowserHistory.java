// 62 ms

class BrowserHistory {
	Stack<String> forward, back;

	public BrowserHistory(String homepage) {
		forward = new Stack<>();
		forward.push(homepage);
		back = new Stack<>();
	}

	public void visit(String url) {
		forward.push(url);
		back = new Stack<>();
	}

	public String back(int steps) {
		while (forward.size() > 1 && steps > 0) {
			back.push(forward.pop());
			steps--;
		}
		return forward.peek();
	}

	public String forward(int steps) {
		while (!back.isEmpty() && steps > 0) {
			forward.push(back.pop());
			steps--;
		}
		return forward.peek();
	}
}

// 47 ms
// node class
class Node {
	String url;
	Node next;
	Node prev;

	Node(String url) {
		this.url = url;
		this.next = null;
		this.prev = null;
	}
}

class BrowserHistory {
	Node head, cur;

	public BrowserHistory(String homepage) {
		head = new Node(homepage);
		cur = head;
	}

	public void visit(String url) {
		Node node = new Node(url);
		cur.next = node;
		node.prev = cur;
		cur = node;
	}

	public String back(int steps) {
		while (cur.prev != null && steps > 0) {
			cur = cur.prev;
			steps--;
		}
		return cur.url;
	}

	public String forward(int steps) {
		while (cur.next != null && steps > 0) {
			cur = cur.next;
			steps--;
		}
		return cur.url;
	}
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage); obj.visit(url); String
 * param_2 = obj.back(steps); String param_3 = obj.forward(steps);
 */