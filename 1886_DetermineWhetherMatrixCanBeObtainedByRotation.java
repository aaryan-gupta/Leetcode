class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean b1 = true, b2 = true, b3 = true, b4 = true;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                if (mat[i][j] != target[i][j])
                    b1 = false;
                if (mat[j][target.length - i - 1] != target[i][j])
                    b2 = false;
                if (mat[target.length - i - 1][target.length - j - 1] != target[i][j])
                    b3 = false;
                if (mat[target.length - j - 1][i] != target[i][j])
                    b4 = false;
            }
        }
        return b1 || b2 || b3 || b4;
    }
}