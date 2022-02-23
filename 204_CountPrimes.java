// 512ms
class Solution {
    public int countPrimes(int n) {
        int a[] = new int[n];
        int count = 0;
        for (int i = 2; i < a.length; i++) {
            for (int j = i + i; j < a.length; j += i)
                a[j] = 1;
        }
        for (int i = 2; i < a.length; i++) {
            if (a[i] == 0)
                count++;
        }
        return count;
    }
}

// 135ms
class Solution {
    public int countPrimes(int n) {
        boolean a[] = new boolean[n];
        int count = 0;
        for (int i = 2; i < a.length; i++) {
            for (int j = i + i; j < a.length; j += i)
                a[j] = true;
        }
        for (int i = 2; i < a.length; i++) {
            if (a[i] == false)
                count++;
        }
        return count;
    }
}

// 20ms
class Solution {
    public int countPrimes(int n) {
        if (n < 3)
            return 0;
        boolean[] primes = new boolean[n];
        int count = 1; // Start at 1 to account for prime value 2, the only even prime
        // Ignore even numbers
        for (int p = 3; p < n; p += 2) {
            // If value is false, then go through and mark all odd multiples of value as
            // true
            if (!primes[p]) {
                count++;
                // Ignore even multiples
                for (int i = p * 3; i < n; i += p * 2)
                    primes[i] = true;
            }
        }
        return count;
    }
}