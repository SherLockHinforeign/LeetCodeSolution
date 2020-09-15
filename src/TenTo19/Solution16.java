package TenTo19;

import java.util.Arrays;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ����ӽ�������֮�ͣ�����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������
 * 				ʹ�����ǵĺ��� target ��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
 * 		���룺 nums = [-1,2,1,-4], target = 1
 * 		�����2
 * 		ע�⣺3 <= nums.length <= 10^3
			-10^3 <= nums[i] <= 10^3
			-10^4 <= target <= 10^4
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
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
	 * @Description: ���� + ˫ָ��
	 * @param  nums  
	 * @param target Ŀ��ֵ
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
		// ö�� a
		for (int first = 0; first <= len; first++) {
			// ��֤����һ��ö�ٵ�Ԫ�ز����
			if (first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			// ʹ��˫ָ��ö�� b �� c
			int second = first + 1, third = len - 1;
			while (second < third) {
				int sum = nums[first] + nums[second] + nums[third];
				// �����Ϊ target ֱ�ӷ��ش�
				if (sum == target) {
					return target;
				}
				// ���ݲ�ֵ�ľ���ֵ�����´�
				if (Math.abs(sum - target) < Math.abs(best - target)) {
					best = sum;
				}
				if (sum > target) {
					// ����ʹ��� target���ƶ� c ��Ӧ��ָ��
					int k0 = third - 1;
					// �ƶ�����һ������ȵ�Ԫ��
					while (second < k0 && nums[k0] == nums[third]) {
						--k0;
					}
					third = k0;
				} else {
					// �����С�� target���ƶ� b ��Ӧ��ָ��
					int j0 = second + 1;
					// �ƶ�����һ������ȵ�Ԫ��
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
