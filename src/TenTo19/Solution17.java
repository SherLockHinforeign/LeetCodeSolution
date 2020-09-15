package TenTo19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
 * 		���룺 "23"
 * 		�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * 		ע�⣺ 1 ����Ӧ�κ���ĸ��
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution17 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		String nums = "982";
		List<String> ans = solution1(nums);
		for(String s : ans) {			
			System.out.println(s);
		}
	}

	/**
	 * @Title: solution1
	 * @Description: ����
	 * @param 
	 * @return List<String>
	 * @throws
	 */
	public static List<String> solution1(String digits) {
		List<String> ans = new ArrayList<>();
		if (digits.length() == 0) {
			return ans;
		}
		Map<Character, String> phoneMap = new HashMap<Character, String>() {
			{
				put('2', "abc");
				put('3', "def");
				put('4', "ghi");
				put('5', "jkl");
				put('6', "mno");
				put('7', "pqrs");
				put('8', "tuv");
				put('9', "wxyz");
			}
		};
		backtrack(ans, phoneMap, digits, 0, new StringBuffer());
        return ans;
	}

	/**
	 * @Title: backtrack
	 * @Description: TODO
	 * @param ans
	 * @param phoneMap
	 * @param digits
	 * @param i
	 * @param stringBuffer void
	 * @throws 
	 */
	private static void backtrack(List<String> ans, Map<Character, String> phoneMap, String digits, int index,
			StringBuffer stringBuffer) {
		if (index == digits.length()) {
			ans.add(stringBuffer.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
            	stringBuffer.append(letters.charAt(i));
                backtrack(ans, phoneMap, digits, index + 1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
	}

}
