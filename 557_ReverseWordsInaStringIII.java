class Solution {
    public String reverseWords(String s) {
        String a[] = s.split(" ");
        s = "";
        for (int i = 0; i < a.length; i++)
            s += new StringBuilder(a[i]).reverse().toString() + " ";
        return s.trim();
    }
}