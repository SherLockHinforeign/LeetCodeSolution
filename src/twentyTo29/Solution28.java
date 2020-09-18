package twentyTo29;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ��ʵ�� strStr() ������
 * 				����һ�� haystack �ַ�����һ�� needle �ַ�����
 * 				�� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻�  -1��
 * 		���룺 haystack = "hello", needle = "ll"
 * 		����� 2
 * 		ע�⣺�� needle �ǿ��ַ���ʱ����Ӧ������ 0 
 * 
 * @author yjx
 * @date 2020-9-18
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution28 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		String haystack = "hellolll0llllll0l", needle = "ll0l";
		System.out.println(solution1(haystack, needle));
		System.out.println(solution2(haystack, needle));
	}

	/**
	 * @Title: solution1
	 * @Description: �Ӵ���һ�Ƚ� - ����ʱ�临�Ӷ�
	 * @param 
	 * @return void
	 * @throws
	 */
	public static int solution1(String haystack, String needle) {
		int L = needle.length(), n = haystack.length();

		for (int start = 0; start < n - L + 1; ++start) {
			if (haystack.substring(start, start + L).equals(needle)) {
				return start;
			}
		}
		return -1;
	}

	/**
	 * @Title: solution2
	 * @Description: ˫ָ�� - ����ʱ�临�Ӷ�
	 * @param haystack
	 * @param needle
	 * @return intn
	 * @throws
	 */
	public static int solution2(String haystack, String needle) {
		int haystackLen = haystack.length();
		int needleLen = needle.length();
		if (haystackLen < needleLen) {
			return -1;
		}
		if (needleLen == 0) {
			return 0;
		}

		int head = 0;
		while (head < haystackLen - needleLen + 1) {
			while (haystack.charAt(head) != needle.charAt(0)) {
				head++;
			}
			int first = 0;
			int second = 0;
			while (head < haystackLen && second < needleLen && haystack.charAt(head) == needle.charAt(second)) {
				first++;
				second++;
				head++;
			}
			if (second == needleLen) {
				return head - needleLen;
			}
			head = head - first + 1;
		}

		return -1;
	}

	/**
	 * @Title: solution3
	 * @Description: Rabin Karp - �������Ӷ�
	 * @param haystack
	 * @param needle
	 * @return int
	 * @throws
	 */
	public static int solution3(String haystack, String needle) {
		int L = needle.length(), n = haystack.length();
		if (L > n)
			return -1;

		// base value for the rolling hash function
		int a = 26;
		// modulus value for the rolling hash function to avoid overflow
		long modulus = (long) Math.pow(2, 31);

		// compute the hash of strings haystack[:L], needle[:L]
		long h = 0, ref_h = 0;
		for (int i = 0; i < L; ++i) {
			h = (h * a + charToInt(i, haystack)) % modulus;
			ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
		}
		if (h == ref_h)
			return 0;

		// const value to be used often : a**L % modulus
		long aL = 1;
		for (int i = 1; i <= L; ++i)
			aL = (aL * a) % modulus;

		for (int start = 1; start < n - L + 1; ++start) {
			// compute rolling hash in O(1) time
			h = (h * a - charToInt(start - 1, haystack) * aL + charToInt(start + L - 1, haystack)) % modulus;
			if (h == ref_h)
				return start;
		}
		return -1;
	}

	// function to convert character to integer
	public static int charToInt(int idx, String s) {
		return (int) s.charAt(idx) - (int) 'a';
	}
}
