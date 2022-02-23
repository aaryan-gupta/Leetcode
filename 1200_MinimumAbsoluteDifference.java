class Solution {
	lic List<List<Integer>> minimumAbsDifference(int[] arr) {
		.sort(arr);
		ist<Integer>> l = new ArrayList<>();
		= Integer.MAX_VALUE;
		nt  i = 1; i < arr.length; i++)
			
		ath.min(d, Math.abs(arr[i] - arr[i - 1]));
		.ou t.println(d);
			 = 1; i < arr.length; i++) {
			ath.abs(arr[i] - arr[i - 1]);
			ge r> l1 = new ArrayList<>();
				
				 - 1]);
			rr[i]);
			 
				
		1.size() != 0)
		d(l1);
	
		return l;
	}
}