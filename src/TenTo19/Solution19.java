package TenTo19;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 		输入： 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 		输出：当删除了倒数第二个节点后，链表变为 1->2->3->5
 * 		注意：给定的 n 保证是有效的，使用一趟扫描实现
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
 */
public class Solution19 {

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
	 * @Description: 两次遍历
	 * @param 
	 * @return ListNode
	 * @throws
	 */
	public ListNode solution1(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    int length  = 0;
	    ListNode first = head;
	    while (first != null) {
	        length++;
	        first = first.next;
	    }
	    length -= n;
	    first = dummy;
	    while (length > 0) {
	        length--;
	        first = first.next;
	    }
	    first.next = first.next.next;
	    
	    return dummy.next;
	}

	
	/**
	 * @Title: solution2
	 * @Description: 一次遍历
	 * @param head
	 * @param n
	 * @return ListNode
	 * @throws
	 */
	public ListNode solution2(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    
	    return dummy.next;
	}
}
