/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	// Map<Index, TreeMap<level, node.val>>
	Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		if (root == null)
			return null;
		map = new TreeMap<>();
		dfs(root, 0, 0);
		List<List<Integer>> res = new LinkedList<>();
		for (int key : map.keySet()) {
			List<Integer> list = new LinkedList<>();
			TreeMap<Integer, PriorityQueue<Integer>> tm = map.get(key);
			for (int k : tm.keySet()) {
				PriorityQueue<Integer> pq = tm.get(k);
				while (!pq.isEmpty())
					list.add(pq.poll());
			}
			res.add(list);
		}
		return res;
	}

	private void dfs(TreeNode root, int index, int level) {
		if (root == null)
			return;
		map.putIfAbsent(index, new TreeMap<>());
		map.get(index).putIfAbsent(level, new PriorityQueue<>());
		map.get(index).get(level).add(root.val);
		dfs(root.left, index - 1, level + 1);
		dfs(root.right, index + 1, level + 1);
	}
}

// ===================================

/**
 * Definition for a binary tree node. struct TreeNode { int val; TreeNode *left;
 * TreeNode *right; TreeNode() : val(0), left(nullptr), right(nullptr) {}
 * TreeNode(int x) : val(x), left(nullptr), right(nullptr) {} TreeNode(int x,
 * TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {} };
 */
class Solution {
	public:
	using pi = pair<int,int>; 
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        map<int, priority_queue<pi, vector<pi>, greater<pi>> > mp;
	int level = 0;queue<pair<TreeNode*,int>>q;q.push({root, 0}); // 0-->hd
	while(!q.empty())
	{
            int size=q.size();
            while(size--) {
                auto [curr, markVal]=q.front();
                q.pop();
                mp[markVal].push({level, curr->val});
                if(curr->left)
                q.push({curr->left, markVal-1});
                if(curr->right)
                q.push({curr->right, markVal+1});
            }
            level++;
        }vector<vector<int>>ans;for(auto&i:mp)
	{
            vector<int> temp;
            while(!i.second.empty()) {
                temp.push_back(i.second.top().second);
                i.second.pop();
            }
            ans.push_back(temp);
        }return ans;
}};