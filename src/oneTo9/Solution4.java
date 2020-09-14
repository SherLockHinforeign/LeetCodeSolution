package oneTo9;

/**
 * 
 * @author 73503 
 *	题目：给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *	请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 你可以假设 nums1 和 nums2
 * 	不会同时为空。
 * 
 * 	实例： 輸入：nums1 = [1, 2] nums2 = [3, 4] 輸出：中位数是 (2 + 3)/2 = 2.5
 *
 *  Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */

public class Solution4 {

	public static void main(String[] args) {
		// 測試案例
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };

		System.out.println(solution2(nums1, nums2));

	}

	// 二分查找
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
		 * 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1]
		 * 进行比较 这里的 "/" 表示整除 nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个 nums2
		 * 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个 取 pivot = min(pivot1,
		 * pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个 这样 pivot
		 * 本身最大也只能是第 k-1 小的元素 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k
		 * 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组 如果 pivot = pivot2，那么 nums2[0 .. k/2-1]
		 * 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组 由于我们 "删除" 了一些元素（这些元素都比第 k
		 * 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
		 */

		int length1 = nums1.length, length2 = nums2.length;
		int index1 = 0, index2 = 0;
		@SuppressWarnings("unused")
		int kthElement = 0;

		while (true) {
			// 边界情况
			if (index1 == length1) {
				return nums2[index2 + k - 1];
			}
			if (index2 == length2) {
				return nums1[index1 + k - 1];
			}
			if (k == 1) {
				return Math.min(nums1[index1], nums2[index2]);
			}

			// 正常情况
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
		// median1：前一部分的最大值
		// median2：后一部分的最小值
		int median1 = 0, median2 = 0;

		while (left <= right) {
			// 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
			// 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
			int i = (left + right) / 2;
			int j = (m + n + 1) / 2 - i;

			// nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1],
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
