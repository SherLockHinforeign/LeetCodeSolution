package TenTo19;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 			垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 * 		输入： [1,8,6,2,5,4,8,3,7]
 * 		输出：49
 * 		注意：不能倾斜容器，且 n 的值至少为 2
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution11 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		int[] height = {1,8,6,2,1000,1000,8,3,7};
		System.out.println(solution1(height));
	}

	/**
	 * @Title: solution1
	 * @Description: TODO
	 * @param height 存储了高度的数组
	 * @return int 返回最大面积
	 * @throws
	 */
	public static int solution1(int[] height) {
		int len = height.length;
		int left = 0;
		int right = len - 1;
		int ans = 0;

		while(left != right) {
			ans = Math.max(Math.min(height[left], height[right]) * Math.abs(right - left), ans);
			if(height[right] >= height[left]) {
				left++;
			}else {
				right--;
			}
		}
		
		return ans;
	}

}
