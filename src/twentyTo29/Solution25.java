package twentyTo29;



/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 				k 是一个正整数，它的值小于或等于链表的长度。
 * 				如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 		输入： 1->2->3->4->5
 * 		输出：	当 k = 2 时，应当返回: 2->1->4->3->5
 * 				当 k = 3 时，应当返回: 3->2->1->4->5
 * 		注意：算法只能使用常数的额外空间
 * 			  不能只是单纯的改变节点内部的值，而是需要实际进行节点交换
 * 
 * @author yjx
 * @date 2020-9-17
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
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
			// 查看剩余部分长度是否大于等于 k
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
			// 把子链表重新接回原链表
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
