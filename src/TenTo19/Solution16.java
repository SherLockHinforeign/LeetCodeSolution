package TenTo19;

import java.util.Arrays;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：最接近的三数之和，给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 				使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 		输入： nums = [-1,2,1,-4], target = 1
 * 		输出：2
 * 		注意：3 <= nums.length <= 10^3
			-10^3 <= nums[i] <= 10^3
			-10^4 <= target <= 10^4
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution16 {

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
	 * @Description: 排序 + 双指针
	 * @param  nums  
	 * @param target 目标值
	 * @return int
	 * @throws
	 */
	public static int solution1(int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		if (len == 2) {
			return nums[0] + nums[1];
		}
		if (len == 1) {
			return nums[0];
		}

		int best = 1000000;
		// 枚举 a
		for (int first = 0; first <= len; first++) {
			// 保证和上一次枚举的元素不相等
			if (first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			// 使用双指针枚举 b 和 c
			int second = first + 1, third = len - 1;
			while (second < third) {
				int sum = nums[first] + nums[second] + nums[third];
				// 如果和为 target 直接返回答案
				if (sum == target) {
					return target;
				}
				// 根据差值的绝对值来更新答案
				if (Math.abs(sum - target) < Math.abs(best - target)) {
					best = sum;
				}
				if (sum > target) {
					// 如果和大于 target，移动 c 对应的指针
					int k0 = third - 1;
					// 移动到下一个不相等的元素
					while (second < k0 && nums[k0] == nums[third]) {
						--k0;
					}
					third = k0;
				} else {
					// 如果和小于 target，移动 b 对应的指针
					int j0 = second + 1;
					// 移动到下一个不相等的元素
					while (j0 < third && nums[j0] == nums[second]) {
						++j0;
					}
					second = j0;
				}
			}
		}

		return best;
	}
}
