// 3ms
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        // int a[] = new int [];
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            l.add(index[i], nums[i]);
        }
        return l.stream().mapToInt(i -> i).toArray();
    }
}

// 0ms
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int a[] = new int[nums.length];
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < index.length; i++)
            l.add(index[i], nums[i]);
        for (int i = 0; i < nums.length; i++)
            a[i] = l.get(i);
        return a;
    }
}