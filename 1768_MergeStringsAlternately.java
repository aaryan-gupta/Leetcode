class Solution {
    public String mergeAlternately(String word1, String word2) {
        String merged = "";
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length())
            merged += String.valueOf(word1.charAt(i++)) + String.valueOf(word2.charAt(j++));
        if (i < word1.length())
            merged += word1.substring(i);
        if (j < word2.length())
            merged += word2.substring(j);
        return merged;
    }
}

class Solution {
    public String mergeAlternately(String word1, String word2) {
        String merged = "";
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length())
            merged += "" + word1.charAt(i++) + word2.charAt(j++) + "";
        if (i < word1.length())
            merged += word1.substring(i);
        if (j < word2.length())
            merged += word2.substring(j);
        return merged;
    }
}