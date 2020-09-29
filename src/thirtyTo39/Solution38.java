package thirtyTo39;


/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项
 * 		输入：  4
 * 		输出："1211"
 * 		注意：
 * 
 * @author yjx
 * @date 2020-9-28
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution38 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		System.out.println(solution1(10));
	}
	

	/**
	 * @Title: solution1
	 * @Description: TODO
	 * @param 
	 * @return void
	 * @throws
	 */
	public static String solution1(int n) {
		if(n == 1) {
			return "1";
		}
		String s = solution1(n-1);
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		int count = 1;
		char temp = s.charAt(0);
		for(int i = 1; i<len; i++) {
			if(temp == s.charAt(i)) {
				count++;
			}else {
				sb.append(count).append(temp);
				count = 1;
				temp = s.charAt(i);
			}
		}
		sb.append(count).append(temp);
		return sb.toString();
	}

}
