import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0;i<s.length(); i++) {

        	char curr = s.charAt(i);

        	if (curr == '(' || curr == '{' || curr == '[') {
        		stack.push(curr);
        	}else if (curr == ')') {
        		if(!stack.empty() && stack.peek() == '(') stack.pop();
        		else return false;
        	}else if (curr == '}'){
        		if(!stack.empty() && stack.peek() == '{') stack.pop();
        		else return false;
        	}else if (curr == ']') {
        		if(!stack.empty() && stack.peek() == '[') stack.pop();
        		else return false;
        	}
        }


        if (!stack.empty()) return false;
        
        return true;
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.isValid("[(])"));
    }
}