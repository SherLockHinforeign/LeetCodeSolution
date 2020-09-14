package oneTo9;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给出一�? 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转�??
 * 		输入�? -123
 * 		输出�?-321
 * 		注意：数值范围为 [�?2^31,  2^31 �? 1]，如果反转后整数溢出那么就返�? 0�?
 * 
 * @author yjx
 * @date 2020-9-14
 * @Note Commit Message �? 12位时间加�?�? . 加项目名LeetCode（例�?202009111720.LeetCode�?
 */
public class Solution7 {

	/**
	 * @Title: main 
	 * @Description: 提供测试案例
	 * @param args 参数
	 * @return void 返回类型 
	 * @throws
	 */
	public static void main(String[] args) {

	}

	/**
	 * @Title: solution1 
	 * @Description: TODO(这里用一句话描述这个方法的作�?) 
	 * @param x 输入�?个待翻转的整�? 
	 * @return int 返回反转后的整数
	 * @throws
	 */
	public static int solution1(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	/**
	 * @Title: solution2
	 * @Description: TODO(这里用一句话描述这个方法的作�?)
	 * @param x
	 * @return int 
	 * @throws
	 */
	public static int solution2(int x) {
		int ans = 0;
		while (x != 0) {
			if ((ans * 10) / 10 != ans) {
				ans = 0;
				break;
			}
			ans = ans * 10 + x % 10;
			x = x / 10;
		}
		return ans;
	}

}
