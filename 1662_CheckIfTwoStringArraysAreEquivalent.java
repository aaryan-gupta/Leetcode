class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String x = "", y = "";
        for (int i = 0; i < word1.length; i++)
            x += word1[i];
        for (int i = 0; i < word2.length; i++)
            y += word2[i];
        if (x.equals(y))
            return true;
        return false;
    }
}