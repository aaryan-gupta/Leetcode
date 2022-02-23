// 324ms
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

// 308ms
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int j = needle.length();
        for (int i = 0; i <= haystack.length() - j; i++) {
            if (haystack.substring(i, i + j).equals(needle))
                return i;
        }
        return -1;
    }
}