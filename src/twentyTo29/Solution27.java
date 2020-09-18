package twentyTo29;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 				不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 				元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 		输入：  nums = [3,2,2,3], val = 3
 * 		输出：返回新的长度 2
 * 		注意：
 * 
 * @author yjx
 * @date 2020-9-17
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution27 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		int[] nums = {4, 1, 2, 3, 5};
		int val = 4;
		System.out.println(solution2(nums, val));
		for(int i : nums) {
			System.out.println(i);
		}
	}

	/**
	 * @Title: solution1
	 * @Description: 双指针
	 * @param 
	 * @return void
	 * @throws
	 */
	public static int solution1(int[] nums, int val) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}

		int slow = 0;
		for (int fast = 1; fast < len; fast++) {
			if (nums[slow] != nums[fast] && nums[slow] == val) {
				nums[slow] = nums[fast];
				slow++;
			}
		}
		return slow + 1;
	}

	/**
	 * @Title: solution2
	 * @Description: 双指针
	 * @param nums
	 * @param val
	 * @return int
	 * @throws
	 */
	public static int solution2(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				// reduce array size by one
				n--;
			} else {
				i++;
			}
		}
		return n;
	}
}
