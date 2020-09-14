package oneToTen;

/**
 * 
 * @author 73503
 *   	��Ŀ���o���ɂ��ǿյ�朱��Á��ʾ�ɂ���ؓ�������������������Ե�λ���ǰ�������ķ�ʽ�惦������ÿ�����cֻ�ܴ惦һλ���֣�
 *   		����һ���µ�朱��ʾ�����ĺ�
 *  	 ʵ����
 *   		ݔ�룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *   		ݔ����7 -> 0 -> 8
 *
 */

public class Solution2 {

	public static void main(String[] args) {
		// �yԇ����
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode answer = solution1(l1, l2);
		while (answer != null) {
			System.out.print(answer.val + " ");
			answer = answer.next;
		}

	}

	// Solution1
	public static ListNode solution1(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = l1;
		ListNode q = l2;
		ListNode curr = head;
		int carry = 0;

		while (p != null || q != null) {
			int x = (p != null) ? p.getVal() : 0;
			int y = (q != null) ? q.getVal() : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}

		if (carry > 0) {
			curr.next = new ListNode(carry);
		}

		return head.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
	}

	ListNode(int x, ListNode next) {
		this.val = x;
		this.next = next;
	}

	public int getVal() {
		return val;
	}

}