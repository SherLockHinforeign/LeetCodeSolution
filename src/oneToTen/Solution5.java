package oneToTen;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 73503
 *   	��Ŀ������һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
 *   
 *   	ʵ����
 *   		ݔ�룺"babad"
 *   		ݔ����"bab" ע��: "aba" Ҳ��һ����Ч�𰸡�
 *
 *	Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */

public class Solution5 {

	public static void main(String[] args) {
		// �yԇ����

	}

	/**
	 * 	 ��̬�滮
	 * @param s
	 * @return
	 */
	public static String solution1(String s) {
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		String ans = "";
		for (int lentemp = 0; lentemp < len; ++lentemp) {
			for (int i = 0; i + lentemp < len; ++i) {
				int j = i + lentemp;
				if (lentemp == 0) {
					dp[i][j] = true;
				} else if (lentemp == 1) {
					dp[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
				}
				if (dp[i][j] && lentemp + 1 > ans.length()) {
					ans = s.substring(i, i + lentemp + 1);
				}
			}
		}
		return ans;
	}

	/**
	 *	������չ�㷨
	 * 
	 * @param s 
	 * @return
	 */
	public static String solution2(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	/**
	 * 	
	 * @param s
	 * @param left
	 * @param right
	 * @return
	 */
	public static int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			--left;
			++right;
		}
		return right - left - 1;
	}

	/**
	 *	�������㷨
	 * @param s
	 * @return
	 */
	public String solution3(String s) {
		int start = 0, end = -1;
		StringBuffer t = new StringBuffer("#");
		for (int i = 0; i < s.length(); ++i) {
			t.append(s.charAt(i));
			t.append('#');
		}
		t.append('#');
		s = t.toString();

		List<Integer> arm_len = new ArrayList<Integer>();
		int right = -1, j = -1;
		for (int i = 0; i < s.length(); ++i) {
			int cur_arm_len;
			if (right >= i) {
				int i_sym = j * 2 - i;
				int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
				cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
			} else {
				cur_arm_len = expand(s, i, i);
			}
			arm_len.add(cur_arm_len);
			if (i + cur_arm_len > right) {
				j = i;
				right = i + cur_arm_len;
			}
			if (cur_arm_len * 2 + 1 > end - start) {
				start = i - cur_arm_len;
				end = i + cur_arm_len;
			}
		}

		StringBuffer ans = new StringBuffer();
		for (int i = start; i <= end; ++i) {
			if (s.charAt(i) != '#') {
				ans.append(s.charAt(i));
			}
		}
		return ans.toString();
	}

	/**
	 * 
	 * @param s
	 * @param left
	 * @param right
	 * @return
	 */
	public int expand(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			--left;
			++right;
		}
		return (right - left - 2) / 2;
	}
}
