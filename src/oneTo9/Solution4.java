package oneTo9;

/**
 * 
 * @author 73503 
 *	��Ŀ������������СΪ m �� n �����򣨴�С�������� nums1 �� nums2��
 *	�����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log(m + n))�� ����Լ��� nums1 �� nums2
 * 	����ͬʱΪ�ա�
 * 
 * 	ʵ���� ݔ�룺nums1 = [1, 2] nums2 = [3, 4] ݔ������λ���� (2 + 3)/2 = 2.5
 *
 *  Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */

public class Solution4 {

	public static void main(String[] args) {
		// �yԇ����
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };

		System.out.println(solution2(nums1, nums2));

	}

	// ���ֲ���
	public static double solution1(int[] nums1, int[] nums2) {
		int length1 = nums1.length, length2 = nums2.length;
		int totalLength = length1 + length2;
		if (totalLength % 2 == 1) {
			int midIndex = totalLength / 2;
			double median = getKthElement(nums1, nums2, midIndex + 1);
			return median;
		} else {
			int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
			double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1))
					/ 2.0;
			return median;
		}
	}

	public static int getKthElement(int[] nums1, int[] nums2, int k) {
		/*
		 * ��Ҫ˼·��Ҫ�ҵ��� k (k>1) С��Ԫ�أ���ô��ȡ pivot1 = nums1[k/2-1] �� pivot2 = nums2[k/2-1]
		 * ���бȽ� ����� "/" ��ʾ���� nums1 ��С�ڵ��� pivot1 ��Ԫ���� nums1[0 .. k/2-2] ���� k/2-1 �� nums2
		 * ��С�ڵ��� pivot2 ��Ԫ���� nums2[0 .. k/2-2] ���� k/2-1 �� ȡ pivot = min(pivot1,
		 * pivot2)������������С�ڵ��� pivot ��Ԫ�ع��Ʋ��ᳬ�� (k/2-1) + (k/2-1) <= k-2 �� ���� pivot
		 * �������Ҳֻ���ǵ� k-1 С��Ԫ�� ��� pivot = pivot1����ô nums1[0 .. k/2-1] ���������ǵ� k
		 * С��Ԫ�ء�����ЩԪ��ȫ�� "ɾ��"��ʣ�µ���Ϊ�µ� nums1 ���� ��� pivot = pivot2����ô nums2[0 .. k/2-1]
		 * ���������ǵ� k С��Ԫ�ء�����ЩԪ��ȫ�� "ɾ��"��ʣ�µ���Ϊ�µ� nums2 ���� �������� "ɾ��" ��һЩԪ�أ���ЩԪ�ض��ȵ� k
		 * С��Ԫ��ҪС���������Ҫ�޸� k ��ֵ����ȥɾ�������ĸ���
		 */

		int length1 = nums1.length, length2 = nums2.length;
		int index1 = 0, index2 = 0;
		@SuppressWarnings("unused")
		int kthElement = 0;

		while (true) {
			// �߽����
			if (index1 == length1) {
				return nums2[index2 + k - 1];
			}
			if (index2 == length2) {
				return nums1[index1 + k - 1];
			}
			if (k == 1) {
				return Math.min(nums1[index1], nums2[index2]);
			}

			// �������
			int half = k / 2;
			int newIndex1 = Math.min(index1 + half, length1) - 1;
			int newIndex2 = Math.min(index2 + half, length2) - 1;
			int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
			if (pivot1 <= pivot2) {
				k -= (newIndex1 - index1 + 1);
				index1 = newIndex1 + 1;
			} else {
				k -= (newIndex2 - index2 + 1);
				index2 = newIndex2 + 1;
			}
		}
	}

	public static double solution2(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return solution2(nums2, nums1);
		}

		int m = nums1.length;
		int n = nums2.length;
		@SuppressWarnings("unused")
		int left = 0, right = m, ansi = -1;
		// median1��ǰһ���ֵ����ֵ
		// median2����һ���ֵ���Сֵ
		int median1 = 0, median2 = 0;

		while (left <= right) {
			// ǰһ���ְ��� nums1[0 .. i-1] �� nums2[0 .. j-1]
			// ��һ���ְ��� nums1[i .. m-1] �� nums2[j .. n-1]
			int i = (left + right) / 2;
			int j = (m + n + 1) / 2 - i;

			// nums_im1, nums_i, nums_jm1, nums_j �ֱ��ʾ nums1[i-1], nums1[i], nums2[j-1],
			// nums2[j]
			int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
			int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
			int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
			int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

			if (nums_im1 <= nums_j) {
				ansi = i;
				median1 = Math.max(nums_im1, nums_jm1);
				median2 = Math.min(nums_i, nums_j);
				left = i + 1;
			} else {
				right = i - 1;
			}
		}

		return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
	}
}
