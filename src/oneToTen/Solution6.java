package oneToTen;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 		输入： s = "LEETCODEISHIRING", numRows = 3
 * 		输出：LCIRETOESIIGEDHN
 * 
 * @author yjx
 * @date 2020-9-14
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution6 {

	/**
	 * @Title: main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param 
	 * @param args 参数
	 * @return void 返回类型 
	 * @throws
	 */
	public static void main(String[] args) {

		String s = "LEETCODEISHIRING";
		int numRows = 3;
		System.out.println("LCIRETOESIIGEDHN".equals(solution1(s, numRows)));
		System.out.println("LCIRETOESIIGEDHN".equals(solution2(s, numRows)));
	}

	/**
	 * @Title: solution1 
	 * @Description: 按行排序
	 * @param s 输入一个字符串
	 * @param numRows 输入要将字符串转换成多少行
	 * @return String 返回一个字符串
	 * @throws
	 */
	public static String solution1(String s, int numRows) {
		if (numRows == 1)
			return s;

		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++)
			rows.add(new StringBuilder());

		int curRow = 0;
		boolean goingDown = false;

		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1)
				goingDown = !goingDown;
			curRow += goingDown ? 1 : -1;
		}

		StringBuilder ret = new StringBuilder();
		for (StringBuilder row : rows)
			ret.append(row);
		return ret.toString();
	}

	/**
	 * @Title: solution2
	 * @Description: 按行访问
	 * @param  参数
	 * @return void 返回类型
	 * @throws
	 */
	public static String solution2(String s, int numRows) {
		if (numRows == 1)
			return s;

		StringBuilder ret = new StringBuilder();
		int n = s.length();
		int cycleLen = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < n; j += cycleLen) {
				ret.append(s.charAt(j + i));
				if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
					ret.append(s.charAt(j + cycleLen - i));
			}
		}
		return ret.toString();
	}

}
