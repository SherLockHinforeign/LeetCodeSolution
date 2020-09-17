package twentyTo29;

import twentyTo29.Solution24.ListNode;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ������ÿ k ���ڵ�һ����з�ת�����㷵�ط�ת�������
 * 				k ��һ��������������ֵС�ڻ��������ĳ��ȡ�
 * 				����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 * 		���룺 1->2->3->4->5
 * 		�����	�� k = 2 ʱ��Ӧ������: 2->1->4->3->5
 * 				�� k = 3 ʱ��Ӧ������: 3->2->1->4->5
 * 		ע�⣺�㷨ֻ��ʹ�ó����Ķ���ռ�
 * 			  ����ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʽ��нڵ㽻��
 * 
 * @author yjx
 * @date 2020-9-17
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution25 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * @Title: solution1
	 * @Description: TODO
	 * @param 
	 * @return void
	 * @throws
	 */
	public ListNode solution1(ListNode head, int k) {
		ListNode hair = new ListNode(0);
		hair.next = head;
		ListNode pre = hair;

		while (head != null) {
			ListNode tail = pre;
			// �鿴ʣ�ಿ�ֳ����Ƿ���ڵ��� k
			for (int i = 0; i < k; ++i) {
				tail = tail.next;
				if (tail == null) {
					return hair.next;
				}
			}
			ListNode nex = tail.next;
			ListNode[] reverse = myReverse(head, tail);
			head = reverse[0];
			tail = reverse[1];
			// �����������½ӻ�ԭ����
			pre.next = head;
			tail.next = nex;
			pre = tail;
			head = tail.next;
		}

		return hair.next;
	}

	/**
	 * @Title: myReverse
	 * @Description: TODO
	 * @param head
	 * @param tail
	 * @return ListNode[]
	 * @throws
	 */
	public static ListNode[] myReverse(ListNode head, ListNode tail) {
		ListNode prev = tail.next;
		ListNode p = head;
		while (prev != tail) {
			ListNode nex = p.next;
			p.next = prev;
			prev = p;
			p = nex;
		}
		return new ListNode[] { tail, head };
	}

}
