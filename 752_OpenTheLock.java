class Solution {
	public int openLock(String[] deadends, String target) {
		if (target.equals("0000"))
			return 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		boolean[] seen = new boolean[10000];
		for (String el : deadends)
			seen[Integer.parseInt(el)] = true;
		int targ = Integer.parseInt(target);
		if (seen[0])
			return -1;
		for (int turns = 1; !queue.isEmpty(); turns++) {
			int qlen = queue.size();
			for (int i = 0; i < qlen; i++) {
				int curr = queue.poll();
				for (int j = 1; j < 10000; j *= 10) {
					int mask = curr % (j * 10) / j,
							masked = curr - (mask * j);
					for (int k = 1; k < 10; k += 8) {
						int next = masked + (mask + k) % 10 * j;
						if (seen[next])
							continue;
						if (next == targ)
							return turns;
						seen[next] = true;
						queue.add(next);
					}
				}
			}
		}
		return -1;
	}
}

// =================================

class Solution {
	Set<String> vis = new HashSet<>();

	public int openLock(String[] deadends, String target) {
		if (target == null || target.length() == 0)
			return -1;
		for (String s : deadends)
			vis.add(s);
		Queue<String> q = new LinkedList<>();
		q.add("0000");
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				String curr = q.remove();
				if (vis.contains(curr))
					continue;
				if (curr.equals(target))
					return level;
				for (String next : helper(curr)) {
					if (!vis.contains(next))
						q.offer(next);
				}
				vis.add(curr);
			}
			level++;
		}
		return -1;
	}

	public Set<String> helper(String curr) {
		Set<String> s = new HashSet<>();
		char[] arr = curr.toCharArray();
		for (int i = 0; i < 4; i++) {
			char c = arr[i];
			arr[i] = c == '9' ? '0' : (char) (c + 1);
			s.add(new String(arr));
			arr[i] = c == '0' ? '9' : (char) (c - 1);
			s.add(new String(arr));
			arr[i] = c;
		}
		return s;
	}
}