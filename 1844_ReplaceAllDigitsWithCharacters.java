class Solution {
    public String replaceDigits(String s) {
        char a[] = s.toCharArray();
        for (int i = 1; i < a.length; i += 2)
            a[i] = (char) (a[i - 1] + a[i] - 48);
        return String.copyValueOf(a);
    }
}

// =============================================

class Solution {
    public String replaceDigits(String s) {
        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i += 2) {
            ch[i] = shift(ch[i - 1], Character.getNumericValue(ch[i]));
        }
        return String.valueOf(ch);
    }

    public char shift(char c, int x) {
        return (char) ((int) c + x);
    }
}