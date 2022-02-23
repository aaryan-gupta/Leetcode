class Solution {
    public String restoreString(String s, int[] indices) {
        char a[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++)
            a[indices[i]] = s.charAt(i);
        return String.valueOf(a);
    }
}