class Solution {
	public boolean isRobotBounded(String instructions) {
		if (instructions.length() == 0)
			return false;
		int x = 0, y = 0;
		String direction = "North";
		for (char c : instructions.toCharArray()) {
			if (c == 'G') {
				if (direction.equals("North"))
					y++;
				else if (direction.equals("East"))
					x++;
				else if (direction.equals("South"))
					y--;
				else
					x--;
			} else if (c == 'R') {
				if (direction.equals("North"))
					direction = "East";
				else if (direction.equals("East"))
					direction = "South";
				else if (direction.equals("South"))
					direction = "West";
				else
					direction = "North";
			}
			if (c == 'L') {
				if (direction.equals("North"))
					direction = "West";
				else if (direction.equals("East"))
					direction = "North";
				else if (direction.equals("South"))
					direction = "East";
				else
					direction = "South";
			}
		}
		if (x == 0 && y == 0)
			return true;
		if (direction.equals("North"))
			return false;
		return true;
	}
}

// ===================================

class Solution {
	public boolean isRobotBounded(String instructions) {
		int x = 0, y = 0, direction = 0;
		// N 0
		// W 3 E 1
		// S 2
		for (char ch : instructions.toCharArray()) {
			if (ch == 'G') {
				switch (direction) {
					case 0:
						y++;
						break;
					case 1:
						x++;
						break;
					case 2:
						y--;
						break;
					case 3:
						x--;
						break;
				}
			} else if (ch == 'L')
				direction = direction == 0 ? 3 : (direction - 1);
			else if (ch == 'R')
				direction = (direction + 1) % 4;
		}
		if (direction != 0 || (x == 0 && y == 0))
			return true;
		return false;
	}
}