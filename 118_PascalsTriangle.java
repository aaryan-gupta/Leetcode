class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        List<Integer> temp = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(1);
        result.add(t);
        for(int i = 1; i < numRows; i++) {
            List<Integer> p = result.get(i - 1);
            List<Integer> c = new ArrayList<>();
            c.add(1);
            for(int j = 1; j < i; j++) c.add(p.get(j - 1) + p.get(j));
            c.add(1);
            result.add(c);
        }
        return result;
    }
}