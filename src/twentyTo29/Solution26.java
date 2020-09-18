package twentyTo29;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 				不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 		输入： nums = [0,0,1,1,1,2,2,3,3,4]
 * 		输出：应该返回新的长度 5
 * 		注意：
 * 
 * @author yjx
 * @date 2020-9-17
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution26 {

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
	 * @param 
	 * @return void
	 * @throws
	 */
	public static int solution1(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		int slow = 0;
		for (int fast = 1; fast < len; fast++) {
			if (nums[slow] != nums[fast]) {
				slow++;
				nums[slow] = nums[fast];
			}
		}
		return slow + 1;
	}

}
