package thirtyTo39;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 		输入： candidates = [2,3,6,7], target = 7,
 * 		输出：[
 *			  [7],
 *			  [2,2,3]
 *			]
 * 		注意：所有数字（包括 target）都是正整数。
 * 				解集不能包含重复的组合。 
 * 				1 <= candidates.length <= 30
 *				1 <= candidates[i] <= 200
 *				candidate 中的每个元素都是独一无二的。
 *				1 <= target <= 500
 * 
 * @author yjx
 * @date 2020-9-28
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
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
	 * @Description: 回溯
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
		// 直接跳过
		dfs(candidates, target, ans, combine, idx + 1);
		// 选择当前数
		if (target - candidates[idx] >= 0) {
			combine.add(candidates[idx]);
			dfs(candidates, target - candidates[idx], ans, combine, idx);
			combine.remove(combine.size() - 1);
		}

	}

}
