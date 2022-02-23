class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int c = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.contains(Character.toString(stones.charAt(i))))
                c++;
        }
        return c;
    }
}