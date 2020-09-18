package twentyTo29;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 				返回被除数 dividend 除以除数 divisor 得到的商。
 * 				整数除法的结果应当截去（truncate）其小数部分
 * 		输入： dividend = 10, divisor = 3
 * 		输出： 3
 * 		注意： 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 				被除数和除数均为 32 位有符号整数。除数不为 0。
 * 				假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。
 * 				本题中，如果除法结果溢出，则返回 2^31 − 1。
 * 
 * @author yjx
 * @date 2020-9-18
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution29 {

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
	 * @param dividend
	 * @param divisor
	 * @return int
	 * @throws
	 */
	public static int solution1(int dividend, int divisor) {
		if (divisor == 0) {
			return 0;
		}
		boolean dividendIsBetween = dividend <= Integer.MAX_VALUE && dividend >= Integer.MIN_VALUE ? true : false;
		if (divisor == 1) {
			return dividendIsBetween ? dividend : Integer.MAX_VALUE;
		}
		if (divisor == -1) {
			return dividendIsBetween ? dividend : Integer.MIN_VALUE;
		}

		long dividendL = dividend;
		long divisorL = divisor;
		int sign = 1;
		if ((dividendL > 0 && divisorL < 0) || (dividendL < 0 && divisorL > 0)) {
			sign = -1;
		}
		dividendL = dividendL > 0 ? dividendL : -dividendL;
		divisorL = divisorL > 0 ? divisorL : -divisorL;
		int result = div(dividendL, divisorL);
		if (sign > 0) {
			return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
		}
		return -result;
	}

	public static int div(long dividendL, long divisorL) {
		if (dividendL < divisorL) {
			return 0;
		}
		int count = 1;
		long divisorL_temp = divisorL;
		while (dividendL >= divisorL_temp + divisorL_temp) {
			count = count + count;
			divisorL_temp = divisorL_temp + divisorL_temp;
		}
		return count + div(dividendL - divisorL_temp, divisorL);
	}

}
