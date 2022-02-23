// 1ms
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int start = 0, end = image[i].length - 1;
            while (start < end) {
                int t = image[i][start];
                image[i][start] = image[i][end];
                image[i][end] = t;
                start++;
                end--;
            }
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == 0)
                    image[i][j] = 1;
                else
                    image[i][j] = 0;
            }
        }
        return image;
    }
}

// 0ms
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] res = new int[image.length][image.length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                res[i][j] = image[i][image[i].length - 1 - j];
                if (res[i][j] == 0)
                    res[i][j] = 1;
                else if (res[i][j] == 1)
                    res[i][j] = 0;
            }
        }
        return res;
    }
}