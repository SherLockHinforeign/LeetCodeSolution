package TenTo19;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������ n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ���������ڻ� n ����ֱ�ߣ�
 * 			��ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)���ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ
 * 		���룺 [1,8,6,2,5,4,8,3,7]
 * 		�����49
 * 		ע�⣺������б�������� n ��ֵ����Ϊ 2
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution11 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		int[] height = {1,8,6,2,1000,1000,8,3,7};
		System.out.println(solution1(height));
	}

	/**
	 * @Title: solution1
	 * @Description: TODO
	 * @param height �洢�˸߶ȵ�����
	 * @return int ����������
	 * @throws
	 */
	public static int solution1(int[] height) {
		int len = height.length;
		int left = 0;
		int right = len - 1;
		int ans = 0;

		while(left != right) {
			ans = Math.max(Math.min(height[left], height[right]) * Math.abs(right - left), ans);
			if(height[right] >= height[left]) {
				left++;
			}else {
				right--;
			}
		}
		
		return ans;
	}

}
