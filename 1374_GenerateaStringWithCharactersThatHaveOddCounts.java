class Solution {
    public String generateTheString(int n) {
        String s = "a".repeat(n-1);
        return n % 2 == 0 ? s + "b" : s + "a";
    }
}