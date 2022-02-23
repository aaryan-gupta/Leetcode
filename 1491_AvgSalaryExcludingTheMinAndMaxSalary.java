class Solution {
    public double average(int[] salary) {
        int min = salary[0], max = salary[0], sum = 0;
        for (int i = 0; i < salary.length; i++) {
            if (min > salary[i])
                min = salary[i];
            if (max < salary[i])
                max = salary[i];
            sum += salary[i];
        }
        return (sum - max - min) / (double) (salary.length - 2);
    }
}

class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0;
        for (int i = 1; i < salary.length - 1; i++)
            sum += salary[i];
        return sum / (salary.length - 2);
    }
}