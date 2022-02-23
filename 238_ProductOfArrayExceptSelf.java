class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length], l = 1, r = 1;
        for(int i = 0; i < nums.length; i++) res[i] = 1;
        for(int i = 0, j = nums.length - 1; i < nums.length - 1; i++, j--) {
            l *= nums[i];
            r *= nums[j];
            res[i + 1] *= l;
            res[j - 1] *= r;
        }
        return res;
    }
}