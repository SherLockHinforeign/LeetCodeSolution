package TenTo19;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ�� ����ת��������
 * 		���룺 58
 * 		�����"LVIII"
 * 		ע�⣺�ַ�                    ��ֵ
 *			  I             1
 *			  V             5
 * 			  X             10
 *			  L             50
 *			  C             100
 *			  D             500
 *			  M             1000
 *
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution12 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {

	}
	
	static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
	static String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	/**
	 * @Title: solution1
	 * @Description: ̰���㷨
	 * @param num ����һ������
	 * @return String ���ص����������ַ���
	 * @throws
	 */
	public static String solution1(int num) {
		StringBuilder sb = new StringBuilder();
	    // Loop through each symbol, stopping if num becomes 0.
	    for (int i = 0; i < values.length && num >= 0; i++) {
	        // Repeat while the current symbol still fits into num.
	        while (values[i] <= num) {
	            num -= values[i];
	            sb.append(symbols[i]);
	        }
	    }
	    return sb.toString();
	}

	
}
