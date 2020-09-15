package twentyTo29;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 		输入： "()[]{}"
 * 		输出：true
 * 		注意：
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution20 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {

	}

	/**
	 * @Title: solution1
	 * @Description: 栈
	 * @param 
	 * @return boolean
	 * @throws
	 */
	public static boolean solution1(String s) {
		int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        
        return stack.isEmpty();
	}

}
