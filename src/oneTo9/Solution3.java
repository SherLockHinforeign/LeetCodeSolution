package oneTo9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author 73503 
 * 		��Ŀ������һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ���
 * 
 *     	ʾ�� 1: ����: "abcabcbb" ���: 3 ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * 
 *  	ʾ�� 2: ����: "bbbbb" ���: 1 ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * 
 *    	ʾ�� 3: ����: "pwwkew" ���: 3 ����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
 *     	��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
 */

public class Solution3 {

	public static void main(String[] args) {
		// �yԇ����

	}

	// ��������
	public static int Solution1(String s) {
		// ��ϣ���ϣ���¼ÿ���ַ��Ƿ���ֹ�
		Set<Character> set = new HashSet<>();
		int len = s.length();
		// ��ָ��
		int rk = -1;
		// ��¼������г���
		int ans = 0;

		for (int i = 0; i < len; i++) {
			if (i != 0) {
				// ��ָ�������ƶ�һ��,�Ƴ�һ���ַ�
				set.remove(s.charAt(i - 1));
			}
			// ����һ���ַ�������set��
			while (rk + 1 < len && !set.contains(s.charAt(rk + 1))) {
				set.add(s.charAt(rk + 1));
				rk++;
			}
			ans = Math.max(ans, rk - i + 1);
		}

		return ans;
	}

	// ����ָ��
	public static int Solution2(String s) {
		int len = s.length();
		if (s.length() <= 1) {
			return s.length();
		}

		int result = 0;
		// ͨ����ϣ�������ٶ�λ�ظ��ַ�������λ��
		Map<Character, Integer> map = new HashMap<>();
		// ����ָ���ָ��ָ�����µ��±�,��ָ��ָ���ظ�����С�±�
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
