package oneToTen;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 73503
 *   	��Ŀ���o��һ���������Mnums��һ��Ŀ��ֵtarget��Ո��ԓ���M���ҳ��͠�Ŀ��ֵ���ǃɂ������������������Ĕ��M�ˣ����M��
 *   		ͬһ��Ԫ�ز���ʹ�Ãɴ�
 *   	ʵ�����o��nums=[2,7,11,15],target=9
 *   	����0,1
 *
 */

public class Solution1 {

	public static void main(String[] args) {
		// �yԇ����
		
	}
	
	/**
	 * solution1
	 *  	�����ƽ�
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] solution1(int[] nums, int target) {
		int[] solution = new int[2];
		for(int i = 0; i<nums.length; i++) {
			int first = nums[i];
			int second = target - first;
			for(int j = i+1; j<nums.length; j++) {
				if(nums[j] == second) {
					solution[0] = i;
					solution[1] = j;
				}
			}
		}
		return solution;
	}
	
	/**
	 *  solution2
	 *  	��߅��ϣ��
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] solution2(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i<nums.length; i++) {
			map.put(nums[i], i);
		}
		for(int j = 0; j<nums.length; j++) {
			int first = nums[j];
			int second = target - first;
			if(map.containsKey(second) && map.get(second) != j) {
				return new int[] {j, map.get(second)};
			}
		}
		throw new IllegalArgumentException("�]�д�");
	}
	
}