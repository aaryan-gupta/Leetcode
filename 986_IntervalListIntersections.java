class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int []> a = new ArrayList<>();
        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length) {
            int l = Math.max(firstList[i][0], secondList[j][0]);
            int h = Math.min(firstList[i][1], secondList[j][1]);
            if(l <= h) a.add(new int []{l, h});
            if(firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }
        return a.toArray(new int[a.size()][]);
    }
}