package thirtyTo39;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 * 		���룺 candidates = [2,3,6,7], target = 7,
 * 		�����[
 *			  [7],
 *			  [2,2,3]
 *			]
 * 		ע�⣺�������֣����� target��������������
 * 				�⼯���ܰ����ظ�����ϡ� 
 * 				1 <= candidates.length <= 30
 *				1 <= candidates[i] <= 200
 *				candidate �е�ÿ��Ԫ�ض��Ƕ�һ�޶��ġ�
 *				1 <= target <= 500
 * 
 * @author yjx
 * @date 2020-9-28
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution39 {

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
	 * @Description: ����
	 * @param 
	 * @return void
	 * @throws
	 */
	public static List<List<Integer>> solution1(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> combine = new ArrayList<Integer>();
		dfs(candidates, target, ans, combine, 0);
		return ans;
	}

	/**
	 * @Title: dfs
	 * @Description: TODO
	 * @param candidates
	 * @param target
	 * @param ans
	 * @param combine
	 * @param i void
	 * @throws 
	 */
	private static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
		if (idx == candidates.length) {
			return;
		}
		if (target == 0) {
			ans.add(new ArrayList<Integer>(combine));
			return;
		}
		// ֱ������
		dfs(candidates, target, ans, combine, idx + 1);
		// ѡ��ǰ��
		if (target - candidates[idx] >= 0) {
			combine.add(candidates[idx]);
			dfs(candidates, target - candidates[idx], ans, combine, idx);
			combine.remove(combine.size() - 1);
		}

	}

}
