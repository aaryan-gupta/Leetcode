class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        for (int i = 1; i < gain.length; i++) {
            gain[i] = gain[i] + gain[i - 1];
            if (gain[i] >= max)
                max = gain[i];
        }
        if (max < 0)
            return max;
        return Math.max(max, gain[0]);
    }
}