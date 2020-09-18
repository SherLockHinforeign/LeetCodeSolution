package twentyTo29;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ���������飬����Ҫ�� ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * 				��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�
 * 		���룺 nums = [0,0,1,1,1,2,2,3,3,4]
 * 		�����Ӧ�÷����µĳ��� 5
 * 		ע�⣺
 * 
 * @author yjx
 * @date 2020-9-17
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution26 {

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
	 * @Description: TODO
	 * @param 
	 * @return void
	 * @throws
	 */
	public static int solution1(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		int slow = 0;
		for (int fast = 1; fast < len; fast++) {
			if (nums[slow] != nums[fast]) {
				slow++;
				nums[slow] = nums[fast];
			}
		}
		return slow + 1;
	}

}
