class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}

// ============================

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = hm.get(target - nums[i]);
            } else
                hm.put(nums[i], i);
        }
        return res;
    }
}