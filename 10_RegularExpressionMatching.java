
// 72 ms
import java.util.regex.*;

class Solution {
	public boolean isMatch(String s, String r) {
		Pattern p = Pattern.compile(r);
		Matcher m = p.matcher(s);
		if (m.find() && m.group().equals(s))
			return true;
		return false;
	}
}

// 40 ms
class Solution {
	public boolean isMatch(String s, String r) {
		return s.matches(r);
	}
}