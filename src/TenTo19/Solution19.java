package TenTo19;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣
 * 		���룺 ����һ������: 1->2->3->4->5, �� n = 2.
 * 		�������ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5
 * 		ע�⣺������ n ��֤����Ч�ģ�ʹ��һ��ɨ��ʵ��
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
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
	 * @Description: ���α���
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
	 * @Description: һ�α���
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
