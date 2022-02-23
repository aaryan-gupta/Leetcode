class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int s = arr.length - i;
            int e = i + 1;
            int t = s * e;
            int odd = t / 2;
            if (t % 2 != 0)
                odd++;
            result += odd * arr[i];
        }
        return result;
    }
}