package twentyTo29;

import java.util.PriorityQueue;

import twentyTo29.Solution21.ListNode;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ���������飬ÿ�������Ѿ����������С����㽫��������ϲ���һ�����������У����غϲ��������
 * 		���룺 lists = [[1,4,5],[1,3,4],[2,6]]
 * 		����� [1,1,2,3,4,4,5,6]
 * 		ע�⣺     k == lists.length
				0 <= k <= 10^4
				0 <= lists[i].length <= 500
				-10^4 <= lists[i][j] <= 10^4
				lists[i] �� ���� ����
				lists[i].length ���ܺͲ����� 10^4
 * 
 * @author yjx
 * @date 2020-9-17
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution23 {

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
	 * @Description: ˳��ϲ�
	 * @param 
	 * @return ListNode
	 * @throws
	 */
	public static ListNode solution1(ListNode[] lists) {
		int k = lists.length;
		for(int i = 0; i<k; i++) {
			ListNode ln1 = lists[i];
			ListNode ln2 = lists[i+1];
			ln2 = mergeKLists(ln1, ln2);
		}
		return lists[k-1];
	}
	
	/**
	 * @Title: mergeKLists
	 * @Description: �ϲ���������
	 * @param l1
	 * @param l2
	 * @return ListNode
	 * @throws
	 */
	public static ListNode mergeKLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeKLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeKLists(l1, l2.next);
            return l2;
        }
	}
	
	
	/**
	 * @Title: solution2
	 * @Description: ���κϲ�
	 * @param lists
	 * @return ListNode
	 * @throws
	 */
	public static ListNode solution2(ListNode[] lists) {
		return merge(lists, 0, lists.length);
	}
	
	/**
	 * @Title: merge
	 * @Description: TODO
	 * @param lists
	 * @param l
	 * @param r
	 * @return ListNode
	 * @throws
	 */
	public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeKLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
	
	
	
	/**
	 * 
	 * @ClassName: Status
	 * @Description: TODO
	 * @author yjx
	 * @date 2020-9-17
	 */
	class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();
    /**
	 * @Title: solution3
	 * @Description: ʹ�����ȶ��кϲ�
	 * @param lists
	 * @return ListNode
	 * @throws
	 */
    public ListNode solution3(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }
}
