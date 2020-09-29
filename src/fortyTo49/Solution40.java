package fortyTo49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ������ candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
 * 				candidates �е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
 * 		���룺  candidates = [10,1,2,7,6,1,5], target = 8,
 * 		�����[
			  [1, 7],
			  [1, 2, 5],
			  [2, 6],
			  [1, 1, 6]
			]
 * 		ע�⣺
 * 
 * @author yjx
 * @date 2020-9-29
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution40 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {

	}

	static List<int[]> freq = new ArrayList<int[]>();
	static List<List<Integer>> ans = new ArrayList<List<Integer>>();
	static List<Integer> sequence = new ArrayList<Integer>();

	/**
	 * @Title: solution1
	 * @Description: TODO
	 * @param 
	 * @return void
	 * @throws
	 */
	public static List<List<Integer>> solution1(int[] candidates, int target) {
		Arrays.sort(candidates);
		for (int num : candidates) {
			int size = freq.size();
			if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
				freq.add(new int[] { num, 1 });
			} else {
				++freq.get(size - 1)[1];
			}
		}
		dfs(0, target);
		return ans;
	}

	/**
	 * @Title: dfs
	 * @Description: �ݹ�+����
	 * @param i
	 * @param target 
	 * @return void
	 * @throws 
	 */
	private static void dfs(int pos, int rest) {
		if (rest == 0) {
			ans.add(new ArrayList<Integer>(sequence));
			return;
		}
		if (pos == freq.size() || rest < freq.get(pos)[0]) {
			return;
		}
		dfs(pos + 1, rest);

		int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
		for (int i = 1; i <= most; i++) {
			sequence.add(freq.get(pos)[0]);
			dfs(pos + 1, rest - i * freq.get(pos)[0]);
		}
		for (int j = 1; j <= most; j++) {
			sequence.remove(sequence.size() - 1);
		}
	}
}
