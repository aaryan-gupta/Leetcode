class Solution {
	public int find(int x, int[] parent) {
		if (parent[x] == -1)
			return x;
		else
			parent[x] = find(parent[x], parent);
		return parent[x];
	}

	public void union(int x, int y, int[] parent) {
		int xp = find(x, parent);
		int yp = find(y, parent);
		if (xp != yp) {
			parent[yp] = xp;
		}
		return;
	}

	public int largestComponentSize(int[] nums) {
		int[] parent = new int[100001];
		Arrays.fill(parent, -1);
		int i;
		for (i = 0; i < nums.length; i++) {
			for (int k = 2; k <= Math.sqrt(nums[i]); k++) {
				if (nums[i] % k == 0) {
					union(nums[i], k, parent);
					union(nums[i], nums[i] / k, parent);
				}
			}
		}
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (i = 0; i < nums.length; i++) {
			int p = find(nums[i], parent);
			count = Math.max(count, map.getOrDefault(p, 0) + 1);
			map.put(p, map.getOrDefault(p, 0) + 1);
		}
		return count;
	}
}

// ==========================================

class DSU {
	ArrayList<Integer> parent = new ArrayList();

	public DSU(int n) {
		for (int i = 0; i < n; i++)
			parent.add(i);
	}

	int findParent(int n) {
		if (parent.get(n) == n)
			return n;
		parent.set(n, findParent(parent.get(n)));
		return parent.get(n);
	}

	void union(int u, int v) {
		int uParent = findParent(u);
		int vParent = findParent(v);

		if (uParent != vParent)
			parent.set(uParent, parent.get(vParent));
	}
}

class Solution {
	public int largestComponentSize(int[] nums) {
		int n = nums.length;
		int x = nums[0];
		for (int num : nums)
			x = Math.max(x, num);
		DSU dsu = new DSU(x + 1);

		for (int num : nums) {
			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					dsu.union(num, i);
					dsu.union(num, num / i);
				}
			}
		}
		Map<Integer, Integer> map = new HashMap();
		int ans = 1;
		for (int num : nums) {
			int par = dsu.findParent(num);
			map.put(par, map.getOrDefault(par, 0) + 1);
			ans = Math.max(ans, map.get(par));
		}
		return ans;
	}
}