class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        int price = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            price += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            price += costs[i][1];
        }
        return price;
    }
}

// ===================================

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        // System.out.println(Arrays.toString(costs));
        int min = 0;
        for (int i = 0; i < costs.length; i++) {
            min += i >= costs.length / 2 ? costs[i][1] : costs[i][0];
        }
        return min;
    }
}