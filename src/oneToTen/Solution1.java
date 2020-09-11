package oneToTen;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 73503
 *   	题目：給定一個整數數組nums和一個目標值target，請在該數組中找出和爲目標值的那兩個整數，并返回他們的數組下標，數組中
 *   		同一個元素不能使用兩次
 *   	实例：給定nums=[2,7,11,15],target=9
 *   	返回0,1
 *
 */

public class Solution1 {

	public static void main(String[] args) {
		// 測試案例
		
	}
	
	/**
	 * solution1
	 *  	暴力破解
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
	 *  	兩邊哈希表
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
		throw new IllegalArgumentException("沒有答案");
	}
	
}