// 1 ms
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex == 0)
            return ans; // [1]
        ans.add(1);
        if (rowIndex == 1)
            return ans; // [1, 1]
        int count = 1; // rowIndex > 1
        while (count <= rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 0; i < count - 1; i++) {
                row.add(ans.get(i) + ans.get(i + 1)); // calculating new row from previous/ans row
            }
            row.add(1);
            ans = row; // setting previous row as new_row
            count++;
        }
        return ans;
    }
}

// 2 ms
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            return l;
        }
        if (rowIndex == 1) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            l.add(1);
            return l;
        }
        List<Integer> oldRow = getRow(rowIndex - 1), newRow = new ArrayList<>();
        newRow.add(1);
        for (int i = 0; i < oldRow.size() - 1; i++)
            newRow.add(oldRow.get(i) + oldRow.get(i + 1));
        newRow.add(1);
        return newRow;
    }
}