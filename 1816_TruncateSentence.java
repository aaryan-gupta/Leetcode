// 1ms
class Solution {
    public String truncateSentence(String s, int k) {
        int count = 0;
        String a = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                count++;
            if (count < k)
                a = s.substring(0, i + 1);
        }
        return a;
    }
}

// 5ms
class Solution {
    public String truncateSentence(String s, int k) {
        String ary[] = s.split(" ");
        String t = "";
        for (int i = 0; i < k; i++)
            t += ary[i] + " ";
        return t.trim();
    }
}