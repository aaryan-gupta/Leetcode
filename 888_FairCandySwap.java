class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> set = new HashSet<>();
        int sumA = 0, sumB = 0;
        for (int i : aliceSizes) {
            sumA += i;
            set.add(i);
        }
        for (int i : bobSizes)
            sumB += i;
        for (int i : bobSizes) {
            if (set.contains((sumA - sumB + 2 * i) / 2))
                return new int[] { (sumA - sumB + 2 * i) / 2, i };
        }
        return new int[] { 0, 0 };
    }
}
/*
 * We need to find X and Y values that satisfy below conditions sumA + Y - X ==
 * sumB + X - Y sumA + 2Y - sumB = 2X X = (sumA - sumB + 2Y)/2 populate all the
 * values of Array A in a set loop through all the values of array B and
 * calculate below formalu and check if the result exists in Array A
 */