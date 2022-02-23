class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int a[] = new int [s.length() + 1];
        a[0] = 1;
        a[1] = 1;
        for(int i = 2; i <= s.length(); i++) {
            int oneInt = Integer.valueOf(s.substring(i - 1, i));
            int twoInt = Integer.valueOf(s.substring(i - 2, i));
            if(oneInt >= 1) a[i] += a[i - 1];
            if(twoInt >= 10 && twoInt <= 26) a[i] += a[i - 2];
        }
        return a[s.length()];
    }
}