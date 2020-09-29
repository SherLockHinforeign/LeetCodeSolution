package thirtyTo39;

import java.util.HashMap;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ���ж�һ�� 9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�
 * 				���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * 				���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * 				���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
 * 		���룺
 *  	[
  		  ["5","3",".",".","7",".",".",".","."],
		  ["6",".",".","1","9","5",".",".","."],
		  [".","9","8",".",".",".",".","6","."],
		  ["8",".",".",".","6",".",".",".","3"],
		  ["4",".",".","8",".","3",".",".","1"],
		  ["7",".",".",".","2",".",".",".","6"],
		  [".","6",".",".",".",".","2","8","."],
		  [".",".",".","4","1","9",".",".","5"],
		  [".",".",".",".","8",".",".","7","9"]
		]
 * 		����� true
 * 		ע�⣺	һ����Ч�������������ѱ���䣩��һ���ǿɽ�ġ�
 * 				ֻ��Ҫ�������Ϲ�����֤�Ѿ�����������Ƿ���Ч���ɡ�
 * 				������������ֻ�������� 1-9 ���ַ� '.' ��
 * 				����������Զ�� 9x9 ��ʽ�ġ�
 * 
 * @author yjx
 * @date 2020-9-22
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution36 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {

	}

	/**
	 * @Title: solution1
	 * @Description: һ��ɨ��
	 * @param 
	 * @return void
	 * @throws
	 */
	public static boolean solution1(char[][] board) {
		HashMap<Integer, Integer>[] column = new HashMap[9];
		HashMap<Integer, Integer>[] row = new HashMap[9];
		HashMap<Integer, Integer>[] boxes = new HashMap[9];
		
		for(int i = 0; i< 9; i++) {
			column[i] = new HashMap<>();
			row[i] = new HashMap<>();
			boxes[i] = new HashMap<>();
			for(int j = 0; j<9; j++) {
				char num = board[i][j];
				if(num != '.') {
					int n = (int)num;
					int index = (i/3)*3+j/3;
					
					row[i].put(n, row[i].getOrDefault(n, 0)+1);
					column[j].put(n, column[j].getOrDefault(n, 0)+1);
					boxes[index].put(n, boxes[index].getOrDefault(n, 0)+1);
					
					if(row[i].get(n)>1||column[j].get(n)>1||boxes[index].get(n)>1) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

}
