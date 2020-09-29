package twentyTo29;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 		输入： 1->2->4, 1->3->4
 * 		输出：1->1->2->3->4->4
 * 		注意：
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution21 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	/**
	 * @Title: solution1
	 * @Description: 迭代
	 * @param 
	 * @return void
	 * @throws
	 */
	public ListNode solution1(ListNode l1, ListNode l2) {
		ListNode ans = new ListNode(-1);
		ListNode pre = ans;
		while (l1.next != null && l2.next != null) {
			if (l1.val >= l2.val) {
				pre.val = l2.val;
				l2 = l2.next;
			} else {
				pre.val = l1.val;
				l1 = l1.next;
			}
			pre = pre.next;
		}
		
		pre.next = l1 == null ? l1 : l2;

		return ans;
	}
	
	
	/**
	 * 
	 * @Title: solution1
	 * @Description: 递归
	 * @param l1
	 * @param l2
	 * @return ListNode
	 * @throws
	 */
	public ListNode solution2(ListNode l1, ListNode l2) {
		if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = solution2(l1.next, l2);
            return l1;
        } else {
            l2.next = solution2(l1, l2.next);
            return l2;
        }
	}

}
