package TenTo19;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ�������ǰ׺
 * 		���룺 ["flower","flow","flight"]
 * 		�����"fl"
 * 		ע�⣺��������ֻ����Сд��ĸ a-z
 * 
 * @author yjx
 * @date 2020-9-14
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution14 {

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
	 * @Description: ����ɨ��
	 * @param strs �ַ�������
	 * @return String �����ǰ׺
	 * @throws
	 */
	public static String solution1(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		int count = strs.length;
		for (int i = 1; i < count; i++) {
			prefix = longestCommonPrefix(prefix, strs[i]);
			if (prefix.length() == 0) {
				break;
			}
		}
		return prefix;

	}

	/**
	 * @Title: longestCommonPrefix
	 * @Description: TODO
	 * @param str1
	 * @param str2
	 * @return String
	 * @throws
	 */
	public static String longestCommonPrefix(String str1, String str2) {
		int length = Math.min(str1.length(), str2.length());
		int index = 0;
		while (index < length && str1.charAt(index) == str2.charAt(index)) {
			index++;
		}
		return str1.substring(0, index);
	}

	/**
	 * @Title: solution2
	 * @Description: ����ɨ��
	 * @param strs
	 * @return String
	 * @throws
	 */
	public static String solution2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int length = strs[0].length();
		int count = strs.length;
		for (int i = 0; i < length; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < count; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}

	
	/**
	 * @Title: solution3
	 * @Description: ����
	 * @param strs
	 * @return String
	 * @throws
	 */
	public static String solution3(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		} else {
			return longestCommonPrefix(strs, 0, strs.length - 1);
		}
	}

	/**
	 * @Title: longestCommonPrefix
	 * @Description: TODO
	 * @param strs
	 * @param start
	 * @param end
	 * @return String
	 * @throws
	 */
	public static String longestCommonPrefix(String[] strs, int start, int end) {
		if (start == end) {
			return strs[start];
		} else {
			int mid = (end - start) / 2 + start;
			String lcpLeft = longestCommonPrefix(strs, start, mid);
			String lcpRight = longestCommonPrefix(strs, mid + 1, end);
			return commonPrefix(lcpLeft, lcpRight);
		}
	}

	/**
	 * @Title: commonPrefix
	 * @Description: TODO
	 * @param lcpLeft
	 * @param lcpRight
	 * @return String
	 * @throws
	 */
	public static String commonPrefix(String lcpLeft, String lcpRight) {
		int minLength = Math.min(lcpLeft.length(), lcpRight.length());
		for (int i = 0; i < minLength; i++) {
			if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
				return lcpLeft.substring(0, i);
			}
		}
		return lcpLeft.substring(0, minLength);
	}

}
