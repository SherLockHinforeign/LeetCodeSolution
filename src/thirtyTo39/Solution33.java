package thirtyTo39;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 				( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 				搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 		输入：  nums = [4,5,6,7,0,1,2], target = 0
 * 		输出： 	4
 * 		注意：你的算法时间复杂度必须是 O(log n) 级别。你可以假设数组中不存在重复的元素。
 * 
 * @author yjx
 * @date 2020-9-21
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution33 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		int[] nums = { 5, 6, 7, 0, 1, 2, 4 };
		int target = 0;
		System.out.println(solution1(nums, target));
	}

	/**
	 * @Title: solution1
	 * @Description: TODO
	 * @param 
	 * @return int
	 * @throws
	 */
	public static int solution1(int[] nums, int target) {
		int numsLen = nums.length;
		if (numsLen == 0) {
			return -1;
		}
		if (numsLen == 1) {
			return nums[0] == target ? 0 : -1;
		}
		int left = 0;
		int right = numsLen - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid]) {
				return mid;
			}
			if (nums[0] <= nums[mid]) {
				if (target < nums[mid] && target >= nums[0]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target > nums[mid] && target <= nums[numsLen - 1]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

}
