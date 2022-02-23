class Solution {
    public boolean areOccurrencesEqual(String s) {
        int Hash[] = new int[26];
        for (char ch : s.toCharArray())
            Hash[ch - 'a']++;
        for (int i = 0; i < Hash.length; i++) {
            if (Hash[i] != 0 && Hash[i] != Hash[s.charAt(0) - 'a'])
                return false;
        }
        return true;
    }
}