package twentyTo29;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ���������������������ڵĽڵ㣬�����ؽ����������
 * 		���룺 1->2->3->4
 * 		����� 2->1->4->3
 * 		ע�⣺�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 * 
 * @author yjx
 * @date 2020-9-17
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution24 {

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
	 * @Description: �ݹ�
	 * @param 
	 * @return ListNode
	 * @throws
	 */
	public static ListNode solution1(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode firstNode = head;
		ListNode secondNode = head.next;
		
		firstNode.next = solution1(secondNode.next);
		secondNode.next = firstNode;
		
		return secondNode;

	}

	
	/**
	 * @Title: solution2
	 * @Description: ����
	 * @param head
	 * @return ListNode
	 * @throws
	 */
	public ListNode solution2(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
	}
	
}
