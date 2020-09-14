package oneToTen;

/**
 * 
 * @author 73503
 *   	题目：給出兩個非空的鏈表用來表示兩個非負的整數，其中他們各自的位數是按照逆序的方式存儲，并且每個節點只能存儲一位數字，
 *   		返回一個新的鏈表表示他們的和
 *  	 实例：
 *   		輸入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *   		輸出：7 -> 0 -> 8
 *
 */

public class Solution2 {

	public static void main(String[] args) {
		// 測試案例
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