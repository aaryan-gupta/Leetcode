// 2ms
class Solution {
    public char findTheDifference(String s, String t) {
        int sumS = 0, sumT = 0;
        for (int i = 0; i < s.length(); i++)
            sumS += (int) (s.charAt(i));
        for (int i = 0; i < t.length(); i++)
            sumT += (int) (t.charAt(i));
        return (char) (Math.abs(sumS - sumT));
    }
}

// 1ms
class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += s.charAt(i);
        for (int i = 0; i < t.length(); i++)
            sum -= t.charAt(i);
        return (char) (Math.abs(sum));
    }
}