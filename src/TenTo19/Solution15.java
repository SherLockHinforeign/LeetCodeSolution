package TenTo19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������֮��,����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��
 * 				ʹ�� a + b + c = 0 �������ҳ��������������Ҳ��ظ�����Ԫ�顣
 * 		���룺 nums = [-1, 0, 1, 2, -1, -4]
 * 		�����[
 * 				[-1, 0, 1],
 * 				[-1, -1, 2]
 * 			 ]
 * 		ע�⣺���в����԰����ظ�����Ԫ�顣
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution15 {

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
	 * @param nums
	 * @return List<List<Integer>>
	 * @throws
	 */
	public static List<List<Integer>> solution1(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		if (nums == null || nums.length <= 2) {
			return ans;
		}
		
		int n = nums.length;
		// ö�� a
		for (int first = 0; first < n; ++first) {
			// ��Ҫ����һ��ö�ٵ�������ͬ
			if (first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			// c ��Ӧ��ָ���ʼָ����������Ҷ�
			int third = n - 1;
			int target = -nums[first];
			// ö�� b
			for (int second = first + 1; second < n; ++second) {
				// ��Ҫ����һ��ö�ٵ�������ͬ
				if (second > first + 1 && nums[second] == nums[second - 1]) {
					continue;
				}
				// ��Ҫ��֤ b ��ָ���� c ��ָ������
				while (second < third && nums[second] + nums[third] > target) {
					--third;
				}
				// ���ָ���غϣ����� b ����������
				// �Ͳ��������� a+b+c=0 ���� b<c �� c �ˣ������˳�ѭ��
				if (second == third) {
					break;
				}
				if (nums[second] + nums[third] == target) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[first]);
					list.add(nums[second]);
					list.add(nums[third]);
					ans.add(list);
				}
			}
		}
		
		return ans;
	}

}
