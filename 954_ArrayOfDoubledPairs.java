// 701 ms
class Solution {
	public boolean canReorderDoubled(int[] a) {
		Arrays.sort(a);
		int visited[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			if (visited[i] == 0) {
				boolean check = false;
				for (int j = i + 1; j < a.length; j++) {
					if (visited[j] == 0 && (a[i] == 2 * a[j] || a[j] == 2 * a[i])) {
						visited[i] = 1;
						visited[j] = 1;
						check = true;
						break;
					}
				}
				if (check == false) {
					return false;
				}
			}
		}
		return true;
	}
}

// 781 ms

class Solution {
	public boolean canReorderDoubled(int[] a) {
		Arrays.sort(a);
		boolean visited[] = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			if (visited[i] == false) {
				boolean check = false;
				for (int j = i + 1; j < a.length; j++) {
					if (visited[j] == false && (a[i] == 2 * a[j] || a[j] == 2 * a[i])) {
						visited[i] = true;
						visited[j] = true;
						check = true;
						break;
					}
				}
				if (check == false) {
					return false;
				}
			}
		}
		return true;
	}
}