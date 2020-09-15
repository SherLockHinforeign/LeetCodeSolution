package twentyTo29;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 		输入： n = 3
 * 		输出：[
		       "((()))",
		       "(()())",
		       "(())()",
		       "()(())",
		       "()()()"
		     ]
 * 		注意：
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution22 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		int n = 8;
		List<String> ans = solution1(n);
		for (String s : ans) {
			System.out.println(s);
		}
		ans = solution2(n);
		for (String s : ans) {
			System.out.println(s);
		}
	}

	/**
	 * @Title: solution1
	 * @Description: 回溯
	 * @param 
	 * @return List<String>
	 * @throws
	 */
	public static List<String> solution1(int n) {
		List<String> ans = new ArrayList();
		backtrack(ans, new StringBuilder(), 0, 0, n);
		return ans;
	}

	/**
	 * 
	 * @Title: backtrack
	 * @Description: TODO
	 * @param ans
	 * @param cur
	 * @param open
	 * @param close
	 * @param max void
	 * @throws
	 */
	public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
		if (cur.length() == max * 2) {
			ans.add(cur.toString());
			return;
		}
		if (open < max) {
			cur.append("(");
			backtrack(ans, cur, open + 1, close, max);
			cur.deleteCharAt(cur.length() - 1);
		}
		if (close < open) {
			cur.append(")");
			backtrack(ans, cur, open, close + 1, max);
			cur.deleteCharAt(cur.length() - 1);
		}
	}

	
	
	/**
	 * @Title: solution2
	 * @Description: 按括号序列的长度递归
	 * @param n
	 * @return List<String>
	 * @throws
	 */
	public static List<String> solution2(int n) {
		return generate(n);
	}
	
	static ArrayList[] cache = new ArrayList[100];

	public static List<String> generate(int n) {
		if (cache[n] != null) {
			return cache[n];
		}
		ArrayList<String> ans = new ArrayList();
		if (n == 0) {
			ans.add("");
		} else {
			for (int c = 0; c < n; ++c)
				for (String left : generate(c))
					for (String right : generate(n - 1 - c))
						ans.add("(" + left + ")" + right);
		}
		cache[n] = ans;
		return ans;
	}
}
