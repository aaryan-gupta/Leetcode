class Solution {
    public boolean judgeCircle(String moves) {
        int ud = 0, rl = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U')
                ud++;
            else if (moves.charAt(i) == 'D')
                ud--;
            else if (moves.charAt(i) == 'R')
                rl++;
            else if (moves.charAt(i) == 'L')
                rl--;
        }
        if (ud == 0 && rl == 0)
            return true;
        return false;
    }
}