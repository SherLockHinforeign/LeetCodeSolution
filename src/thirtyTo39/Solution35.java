package thirtyTo39;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
 * 		���룺 [1,3,5,6], 5
 * 		�����2
 * 		ע�⣺����Լ������������ظ�Ԫ�ء�
 * 
 * @author yjx
 * @date 2020-9-21
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution35 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 10;
		System.out.println(solution1(nums, target));
	}

	/**
	 * @Title: solution1
	 * @Description: TODO
	 * @param 
	 * @return void
	 * @throws
	 */
	public static int solution1(int[] nums, int target) {
		int numsLen = nums.length;
		int left = 0;
		int right = numsLen - 1;
		int mid = 0;
		while(left <= right) {
			mid = (left + right)/2;
			if (target >= nums[0] && target < nums[mid]) {
				right = mid - 1;
			} else if (target >= nums[mid] && target <= nums[numsLen - 1]) {
				left = mid;
			} else if (target < nums[0]) {
				return 0;
			} else if (target > nums[numsLen - 1]) {
				return numsLen;
			}
			if (target == nums[mid]) {
				return mid;
			} else if (left == right) {
				return left + 1;
			}
		}
		return mid;
	}
	
	
	
	/**
	 * @Title: solution2
	 * @Description: ���ֲ���
	 * @param nums
	 * @param target
	 * @return int
	 * @throws
	 */
	public static int solution2(int[] nums, int target) {
		int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
	}

}
