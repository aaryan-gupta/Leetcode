class Solution {
    public String longestDupSubstring(String s) {
        int l = 1, r = s.length() - 1;
        String result = "";
        while(l <= r) {
            int mid = l + (r - l) / 2;
            String str = rabinKarp(s, mid);
            if(str.length() != 0) {
                result = str;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return result;
    }
    String rabinKarp(String s, int len) {
        Set<Long> set = new HashSet<>();
        long h = hash(s.substring(0, len));
        set.add(h);
        long pow = 1;
        for(int i = 1; i < len; i++) pow *= 10;
        for(int i = 1; i <= s.length() - len; i++) {
            h = nextHash(pow, h, s.charAt(i - 1), s.charAt(i + len - 1));
            if(set.contains(h)) return s.substring(i, i + len);
            set.add(h);
        }
        return "";
    }
    long nextHash(long pow, long hash, char left, char right) {
        return (hash - left * pow) * 10 + right;
    }
    long hash(String s) {
        long hash = 0;
        long mul = 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            hash += s.charAt(i) * mul;
            mul *= 10;
        }
        return hash;
    }
}