// 1ms
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s == "")
            return 0;
        String ary[] = s.split(" ");
        return ary[ary.length - 1].length();
    }
}

// 0ms
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.substring(s.lastIndexOf(" ") + 1).length();
    }
}