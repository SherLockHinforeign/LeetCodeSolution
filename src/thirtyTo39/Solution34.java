package thirtyTo39;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 			如果数组中不存在目标值，返回 [-1, -1]。
 * 		输入：  nums = [5,7,7,8,8,10], target = 8
 * 		输出：[3,4]
 * 		注意：你的算法时间复杂度必须是 O(log n) 级别
 * 
 * @author yjx
 * @date 2020-9-21
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution34 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int[] result = solution1(nums, target);
		for (int i : result) {
			System.out.println(i);
		}
	}

	
	/**
	 * 
	 * @Title: extremeInsertionIndex
	 * @Description: TODO
	 * @param nums
	 * @param target
	 * @param left
	 * @return int
	 * @throws
	 */
	// returns leftmost (or rightmost) index at which `target` should be
	// inserted in sorted array `nums` via binary search.
	private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
		int lo = 0;
		int hi = nums.length;

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] > target || (left && target == nums[mid])) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;
	}

	/**
	 * @Title: solution1
	 * @Description: TODO
	 * @param 
	 * @return void
	 * @throws
	 */
	public static int[] solution1(int[] nums, int target) {
		int[] targetRange = { -1, -1 };

		int leftIdx = extremeInsertionIndex(nums, target, true);

		// assert that `leftIdx` is within the array bounds and that `target`
		// is actually in `nums`.
		if (leftIdx == nums.length || nums[leftIdx] != target) {
			return targetRange;
		}

		targetRange[0] = leftIdx;
		targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

		return targetRange;
	}

}
