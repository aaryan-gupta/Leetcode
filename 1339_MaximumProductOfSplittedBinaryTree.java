// 8 ms
class Solution {
	long ans = 0;
	long totalSum = 0;

	public int maxProduct(TreeNode root) {
		// The first pass of dfs(root) will give us the total sum of the whole tree
		totalSum = dfs(root);
		// The second pass of the dfs(root) will help in calculating the sum of each
		// subtree and finding max
		dfs(root);
		return (int) (ans % (1e9 + 7));
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int currentSum = root.val + dfs(root.left) + dfs(root.right);
		ans = Math.max(ans, (totalSum - currentSum) * currentSum);
		return currentSum;
	}
}

// 12 ms
class Solution {
	public int maxProduct(TreeNode root) {
		long mod = (long) 1e9 + 7;

		long ans = 0;
		List<Integer> allsum = new ArrayList<>();
		long totalsum = treesum(root, allsum);

		for (long sum : allsum)
			ans = Math.max(ans, sum * (totalsum - sum));

		return (int) (ans % mod);

	}

	public int treesum(TreeNode root, List<Integer> allsum) {
		if (root == null)
			return 0;

		int leftsum = treesum(root.left, allsum);
		int rightsum = treesum(root.right, allsum);

		int sum = root.val + leftsum + rightsum;

		allsum.add(sum);
		return sum;
	}
}

// 10 ms
class Solution {
	long sumAll = 0;
	long maxProduct;

	public int maxProduct(TreeNode root) {
		sumAll = modify(root);
		maxProduct = 1;
		findMaxP(root);
		return (int) (maxProduct % (int) (Math.pow(10, 9) + 7));
	}

	public void findMaxP(TreeNode root) {
		if (root == null)
			return;

		if (root.left != null) {
			long ans = (root.left.val * (sumAll - root.left.val));
			maxProduct = Math.max(maxProduct, ans);
			findMaxP(root.left);
		}

		if (root.right != null) {
			long ans = (root.right.val * (sumAll - root.right.val));
			maxProduct = Math.max(maxProduct, ans);
			findMaxP(root.right);
		}
	}

	public int modify(TreeNode root) {
		if (root == null)
			return 0;

		int left = modify(root.left);
		int right = modify(root.right);
		return root.val = root.val + left + right;

	}
}

// 7 ms
class Solution {
	public long omax = Long.MIN_VALUE;
	public long sum = 0;

	public void totalSum(TreeNode node) {
		if (node == null)
			return;
		sum += node.val;
		totalSum(node.left);
		totalSum(node.right);
	}

	public long maxiProduct(TreeNode node, long sum) {
		if (node == null)
			return 0;
		long l = maxiProduct(node.left, sum);
		long r = maxiProduct(node.right, sum);
		long sum1 = l + r + node.val;
		omax = Math.max(omax, sum1 * (sum - sum1));
		return sum1;
	}

	public int maxProduct(TreeNode root) {
		totalSum(root);
		maxiProduct(root, sum);
		return (int) (omax % (int) (Math.pow(10, 9) + 7));
	}
}