package thirtyTo39;

import java.util.Stack;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度
 * 		输入：  "(()"
 * 		输出：2
 * 		注意：
 * 
 * @author yjx
 * @date 2020-9-18
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution32 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(solution1(s));
	}

	/**
	 * @Title: solution1
	 * @Description: TODO
	 * @param 
	 * @return void
	 * @throws
	 */
	public static int solution1(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}

	/**
	 * @Title: solution2
	 * @Description: 栈
	 * @param s
	 * @return int
	 * @throws
	 */
	public static int solution2(String s) {
		int maxans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		return maxans;
	}

	/**
	 * @Title: solution3
	 * @Description: 原地算法
	 * @param s
	 * @return int
	 * @throws
	 */
	public static int solution3(String s) {
		int left = 0, right = 0, maxlength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right > left) {
				left = right = 0;
			}
		}
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left > right) {
				left = right = 0;
			}
		}
		return maxlength;
	}
}
