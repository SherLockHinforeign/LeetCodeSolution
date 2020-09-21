package thirtyTo39;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ�����谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * 				( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
 * 				����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
 * 		���룺  nums = [4,5,6,7,0,1,2], target = 0
 * 		����� 	4
 * 		ע�⣺����㷨ʱ�临�Ӷȱ����� O(log n) ��������Լ��������в������ظ���Ԫ�ء�
 * 
 * @author yjx
 * @date 2020-9-21
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
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
