class Solution {
    public int minStartValue(int[] nums) {
        int a = 1, ans = 1;
        for (int i = 0; i < nums.length; i++) {
            a = a - nums[i];
            if (a > ans)
                ans = a;
        }
        return ans;
    }
}

// =====================================

class Solution {
    public int minStartValue(int[] nums) {
        int minVal = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
            minVal = Math.min(minVal, total);
        }
        return -minVal + 1;
    }
}