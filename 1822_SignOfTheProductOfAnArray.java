class Solution {
    public int arraySign(int[] nums) {
        int count0 = 0, countp = 0, countn = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                countp++;
            } else if (nums[i] == 0) {
                count0++;
            } else if (nums[i] < 0) {
                countn++;
            }
        }
        if (count0 >= 1) {
            return 0;
        }
        if (countn % 2 != 0) {
            return -1;
        }
        return 1;
    }
}