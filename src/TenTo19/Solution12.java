package TenTo19;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目： 整数转罗马数字
 * 		输入： 58
 * 		输出："LVIII"
 * 		注意：字符                    数值
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
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
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
	 * @Description: 贪心算法
	 * @param num 输入一个数字
	 * @return String 返回的罗马数字字符串
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
