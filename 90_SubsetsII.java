class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
        powerSet.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int dupCount = 1;
            while (((i + 1) < nums.length) && nums[i + 1] == nums[i]) {
                dupCount++;
                i++;
            }
            int prevNum = powerSet.size();
            for (int j = 0; j < prevNum; j++) {
                List<Integer> subSet = new ArrayList<Integer>(powerSet.get(j));
                for (int t = 1; t <= dupCount; t++) {
                    subSet.add(nums[i]);
                    powerSet.add(new ArrayList<Integer>(subSet));
                }
            }
        }
        return powerSet;
    }
}

// =======================================

// Preferrable

class Solution {
    HashSet<ArrayList<Integer>> hs = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> anshs = new ArrayList<>();
        if (nums.length == 0)
            return ans;
        ans.add(new ArrayList<>());
        hs.add(new ArrayList<>());
        helper(ans, nums, 0, new ArrayList<>());
        for (ArrayList<Integer> x : hs) {
            anshs.add(x);
        }
        return anshs;
    }

    void helper(List<List<Integer>> ans, int nums[], int index, List<Integer> l) {
        if (index >= nums.length)
            return;
        for (int i = index; i < nums.length; i++) {
            l.add(nums[i]);
            ans.add(new ArrayList<>(l));
            hs.add(new ArrayList<>(l));
            helper(ans, nums, i + 1, l);
            l.remove(l.size() - 1);
        }
    }
}