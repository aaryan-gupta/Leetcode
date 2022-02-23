class Solution {
    public String sortSentence(String s) {
        String a[] = s.split(" ");
        String b[] = new String[a.length];
        for (int i = 0; i < a.length; i++)
            b[Integer.parseInt(a[i].substring(a[i].length() - 1)) - 1] = a[i];
        for (int i = 0; i < b.length; i++)
            b[i] = b[i].substring(0, b[i].length() - 1);
        return String.join(" ", b);
    }
}