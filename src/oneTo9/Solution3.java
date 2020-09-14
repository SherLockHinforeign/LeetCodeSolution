package oneTo9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author 73503 
 * 		题目：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 
 *     	示例 1: 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 *  	示例 2: 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 *    	示例 3: 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *     	请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class Solution3 {

	public static void main(String[] args) {
		// 測試案例

	}

	// 滑动窗口
	public static int Solution1(String s) {
		// 哈希集合，记录每个字符是否出现过
		Set<Character> set = new HashSet<>();
		int len = s.length();
		// 右指针
		int rk = -1;
		// 记录最长子序列长度
		int ans = 0;

		for (int i = 0; i < len; i++) {
			if (i != 0) {
				// 左指针向右移动一格,移除一格字符
				set.remove(s.charAt(i - 1));
			}
			// 当下一个字符不存在set中
			while (rk + 1 < len && !set.contains(s.charAt(rk + 1))) {
				set.add(s.charAt(rk + 1));
				rk++;
			}
			ans = Math.max(ans, rk - i + 1);
		}

		return ans;
	}

	// 快慢指针
	public static int Solution2(String s) {
		int len = s.length();
		if (s.length() <= 1) {
			return s.length();
		}

		int result = 0;
		// 通过哈希表来快速定位重复字符的最新位置
		Map<Character, Integer> map = new HashMap<>();
		// 快慢指针快指针指向最新的下表,慢指针指向不重复的最小下表
		int fast = 0;
		int slow = 0;

		while (fast < len) {
			if (map.containsKey(s.charAt(fast))) {
				slow = Math.max(slow, map.get(s.charAt(fast)) + 1);
			}
			map.put(s.charAt(fast), fast);
			result = Math.max(result, fast - slow + 1);
			fast++;
		}

		return 0;
	}
}
