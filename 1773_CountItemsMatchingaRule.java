class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int c = 0;
        for (List<String> item : items) {
            if ((ruleKey.equals("type") && item.get(0).equals(ruleValue))
                    || (ruleKey.equals("color") && item.get(1).equals(ruleValue))
                    || (ruleKey.equals("name") && item.get(2).equals(ruleValue)))
                c++;
        }
        return c;
    }
}