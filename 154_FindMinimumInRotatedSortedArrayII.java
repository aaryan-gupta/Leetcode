// 192 ms
class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}

// 3 ms
class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++)
            min = Math.min(nums[i], min);
        return min;
    }
}