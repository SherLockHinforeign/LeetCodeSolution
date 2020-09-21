package thirtyTo39;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 * 			��������в�����Ŀ��ֵ������ [-1, -1]��
 * 		���룺  nums = [5,7,7,8,8,10], target = 8
 * 		�����[3,4]
 * 		ע�⣺����㷨ʱ�临�Ӷȱ����� O(log n) ����
 * 
 * @author yjx
 * @date 2020-9-21
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
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
