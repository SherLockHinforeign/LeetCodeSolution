package TenTo19;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ�� ��������ת����
 * 		���룺 "IX"
 * 		�����9
 * 		ע�⣺
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution13 {

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
	 * @Description: TODO
	 * @param s ���������ַ���
	 * @return int �������ֶ�Ӧ����
	 * @throws
	 */
	public static int solution1(String s) {
		int sum = 0;
		int preNum = getValue(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			int num = getValue(s.charAt(i));
			if (preNum < num) {
				sum -= preNum;
			} else {
				sum += preNum;
			}
			preNum = num;
		}
		sum += preNum;
		return sum;
	}

	private static int getValue(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
	
}
