class Solution {
    public int numberOfMatches(int n) {
        int matches = 0, matchesplayed;
        while (n > 1) {
            if (n % 2 == 0) {
                matchesplayed = n / 2;
                matches += matchesplayed;
                n /= 2;
            } else {
                matchesplayed = (n - 1) / 2;
                matches += matchesplayed;
                n = (n - 1) / 2 + 1;
            }
        }
        return matches;
    }
}

class Solution {
    public int numberOfMatches(int n) {
        int sum = 0, m = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                m = n / 2;
                n = m;
            } else {
                m = (n - 1) / 2;
                n = m + 1;
            }
            sum += m;
        }
        return sum;
    }
}