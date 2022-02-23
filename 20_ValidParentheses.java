class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.empty()) {
                if (c == ')' && stack.peek() == '(')
                    stack.pop();
                else if (c == '}' && stack.peek() == '{')
                    stack.pop();
                else if (c == ']' && stack.peek() == '[')
                    stack.pop();
                else
                    stack.push(c);
                continue;
            }
            stack.push(c);
        }
        if (stack.empty())
            return true;
        return false;
    }
}