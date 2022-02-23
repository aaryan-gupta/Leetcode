class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = -1, length = 201;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < length) {
                length = strs[i].length();
                index = i;
            }
        }
        String s = strs[index];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != s.charAt(i))
                    return s.substring(0, i);
            }
        }
        return s;
    }
}