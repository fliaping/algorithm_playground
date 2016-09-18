public class Solution {
	public String convert(String s, int numRows) {
		int i = 1,last = 0,next = 0;
		StringBuffer sb = new StringBuffer();
		if (s.equals("") || numRows == 0) return "";
		if (numRows == 1 || s.length()<=numRows) return s;
		while (i <= numRows) {
			last = i-1;
			sb.append(s.charAt(last));
			boolean isv = true;
			while (true) {
				if (i==1 || i==numRows) {
					next = last+(numRows-1)*2;
				}else {
					if (isv) {
						next = last + (numRows-i)*2;
					}else {
						next = last + (i-1)*2;
					}
				}
				if (next >= s.length()) break;
				sb.append(s.charAt(next));
				isv = !isv;
				last = next;
			}
			i++;
		}
		
		return sb.toString();
	}
}