class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        char ch = letters[0];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] > target) {
                ch = letters[mid];
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ch;
    }
}