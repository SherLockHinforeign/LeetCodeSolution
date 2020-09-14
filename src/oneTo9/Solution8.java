package oneTo9;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：将字符串转换成整数
 * 		输入�? "4193 with words"
 * 		输出�?4193
 * 		注意：假如该字符串中的第�?个非空格字符不是�?个有效整数字符�?�字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换�??
 * 			数�?�范围为 [�?231,  231 �? 1]。如果数值超过这个范围，请返�?  INT_MAX (2^31 �? 1) �? INT_MIN (�?2^31) �?
 * 
 * @author yjx
 * @date 2020-9-14
 */
public class Solution8 {

	/**
	 * @Title: main 
	 * @Description: 提供测试案例
	 * @param args 参数
	 * @return void 返回类型 
	 * @throws
	 */
	public static void main(String[] args) {
		String str = "   -21474836    46 ";
		System.out.println(-21474836 == solution1(str));
	}

	/**
	 * @Title: solution1 
	 * @Description: 
	 * @param str 输入�?个字符串 
	 * @return int 返回字符串中包含的整�?
	 * @throws
	 */
	public static int solution1(String str) {
		int len = str.length();
		// str.charAt(i) 方法回去�?查下标的合法性，�?般先转换成字符数�?
		char[] charArray = str.toCharArray();

		// 1、去除前导空�?
		int index = 0;
		while (index < len && charArray[index] == ' ') {
			index++;
		}

		// 2、如果已经遍历完成（针对极端用例 " "�?
		if (index == len) {
			return 0;
		}

		// 3、如果出现符号字符，仅第 1 个有效，并记录正�?
		int sign = 1;
		char firstChar = charArray[index];
		if (firstChar == '+') {
			index++;
		} else if (firstChar == '-') {
			index++;
			sign = -1;
		}

		// 4、将后续出现的数字字符进行转�?
		// 不能使用 long 类型，这是题目说�?
		int res = 0;
		while (index < len) {
			char currChar = charArray[index];
			// 4.1 先判断不合法的情�?
			if (currChar > '9' || currChar < '0') {
				break;
			}

			// 题目中说：环境只能存�? 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
			if (res > Integer.MAX_VALUE / 10
					|| (res == Integer.MAX_VALUE / 10 
					&& (currChar - '0') > Integer.MAX_VALUE % 10)) {
				return Integer.MAX_VALUE;
			}
			if (res < Integer.MIN_VALUE / 10
					|| (res == Integer.MIN_VALUE / 10 
					&& (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
				return Integer.MIN_VALUE;
			}

			// 4.2 合法的情况下，才考虑转换，每�?步都把符号位乘进�?
			res = res * 10 + sign * (currChar - '0');
			index++;
		}
		return res;
	}

}
