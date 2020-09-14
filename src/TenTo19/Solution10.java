package TenTo19;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * 		输入： s = "aab" p = "c*a*b"
 * 		输出：true
 * 		注意：'.' 匹配任意单个字符 
 * 			 '*' 匹配零个或多个前面的那一个元素
 * 
 * @author yjx
 * @date 2020-9-14
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution10 {

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
	 * @Description: 动态规划
	 * @param s 一个字符串
	 * @param p 一个匹配模式
	 * @return boolean
	 * @throws
	 */
	public static boolean solution1(String s, String p) {

		int m = s.length();
		int n = p.length();

		boolean[][] f = new boolean[m + 1][n + 1];
		f[0][0] = true;
		for (int i = 0; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (p.charAt(j - 1) == '*') {
					f[i][j] = f[i][j - 2];
					if (matches(s, p, i, j - 1)) {
						f[i][j] = f[i][j] || f[i - 1][j];
					}
				} else {
					if (matches(s, p, i, j)) {
						f[i][j] = f[i - 1][j - 1];
					}
				}
			}
		}
		return f[m][n];
	}

	/**
	 * 
	 * @Title: matches
	 * @Description: TODO
	 * @param s
	 * @param p
	 * @param i
	 * @param j
	 * @return boolean
	 * @throws
	 */
	public static boolean matches(String s, String p, int i, int j) {
		if (i == 0) {
			return false;
		}
		if (p.charAt(j - 1) == '.') {
			return true;
		}
		return s.charAt(i - 1) == p.charAt(j - 1);
	}

	
	/**
	 * 
	 * @Title: solution2
	 * @Description: TODO
	 * @param s
	 * @param p
	 * @return boolean
	 * @throws
	 */
	public static boolean solution2(String s, String p) {

		boolean table[][] = new boolean[s.length() + 1][p.length() + 1];

		table[0][0] = true;

		for (int col = 1; col < table[0].length; col++) {
			char ch = p.charAt(col - 1);
			if (col > 1) {
				if (ch == '*') {
					table[0][col] = table[0][col - 2];
				} else {
					table[0][col] = false;
				}
			} else {
				if (ch == '*') {
					table[0][col] = true;
				}
			}
		}

		for (int row = 1; row < table.length; row++) {
			char ch1 = s.charAt(row - 1);
			for (int col = 1; col < table[row].length; col++) {
				char ch2 = p.charAt(col - 1);
				if (ch1 == ch2 || ch2 == '.') {
					table[row][col] = table[row - 1][col - 1];
				} else if (ch2 == '*') {
					if (col > 1) {
						if (table[row][col - 2]) {
							table[row][col] = true; // * 前面的字符出现0次
						} else {
							char prev = p.charAt(col - 2);
							if (prev == ch1 || prev == '.') {
								table[row][col] = table[row - 1][col]; // * 前面的字符出现多次
							}
						}

					}
				}
			}
		}

		boolean lastRow[] = table[table.length - 1];
		return lastRow[lastRow.length - 1];
	}

}
