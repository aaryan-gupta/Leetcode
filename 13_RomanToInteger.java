class Solution {
    public int romanToInt(String s) {
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((i != s.length() - 1) && (convert(c) < convert(s.charAt(i + 1))))
                r -= convert(c);
            else
                r += convert(c);
        }
        return r;
    }

    public int convert(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}