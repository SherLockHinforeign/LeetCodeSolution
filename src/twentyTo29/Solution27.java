package twentyTo29;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ������ nums ��һ��ֵ val������Ҫ ԭ�� �Ƴ�������ֵ���� val ��Ԫ�أ��������Ƴ���������³��ȡ�
 * 				��Ҫʹ�ö��������ռ䣬������ʹ�� O(1) ����ռ䲢 ԭ�� �޸��������顣
 * 				Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * 		���룺  nums = [3,2,2,3], val = 3
 * 		����������µĳ��� 2
 * 		ע�⣺
 * 
 * @author yjx
 * @date 2020-9-17
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
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
	 * @Description: ˫ָ��
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
	 * @Description: ˫ָ��
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
