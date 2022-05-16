class Solution {
    public int numIdenticalPairs(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j)
                    c++;
            }
        }
        return c;
    }
}

// ====================================

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] c = new int[101];
        int ans = 0;
        for (int i : nums)
            c[i]++;
        for (int n : c)
            ans += (n * (n - 1)) / 2;
        return ans;
    }
}