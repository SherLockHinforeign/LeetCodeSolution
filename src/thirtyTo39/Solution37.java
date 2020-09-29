package thirtyTo39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ����дһ������ͨ�����ո��������������
 * 		���룺 
 * 		�����
 * 		ע�⣺һ�������Ľⷨ����ѭ���¹���
 * 			���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * 			���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
 * 			���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
 * 			�հ׸��� '.' ��ʾ��
 * 			���Լ������������ֻ��Ψһ�⡣
 * 			����������Զ�� 9x9 ��ʽ�ġ�
 * 
 * @author yjx
 * @date 2020-9-22	
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution37 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		char[][] board = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' }
		};
		sysout(board);
		System.out.println();
		new Solution37().solution1(board);
		sysout(board);
			
	}
	
	public static void sysout(char[][] board) {
		for(int i = 0; i<9;i++) {
			for(int j = 0; j<9; j++) {
				System.out.print(board[i][j]);
				if(j<8) {
					System.out.print(" ");
				}
				if((j+1)%3==0) {
					System.out.print("|");
				}
			}
			System.out.println();
			if((i+1)%3 == 0 && i<8) {
				System.out.println("--------------------");
			}
		}
	}

	// �洢��
	private boolean[][] line = new boolean[9][9];
	// �洢��
	private boolean[][] column = new boolean[9][9];
	// �洢һ��3*3����
	private boolean[][][] block = new boolean[3][3][9];
	// ��ʾ�Ƿ���ɾŹ���
	private boolean valid = false;
	// �洢�����Ź���
	private List<int[]> spaces = new ArrayList<int[]>();

	/**
	 * @Title: solution1
	 * @Description: �ݹ�+����
	 * @param 
	 * @return void
	 * @throws
	 */
	public void solution1(char[][] board) {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] == '.') {
					spaces.add(new int[] { i, j });
				} else {
					int digit = board[i][j] - '0' - 1;
					line[i][digit] = true;
					column[j][digit] = true;
					block[i / 3][j / 3][digit] = true;
				}
			}
		}
		dfs(board, 0);
	}

	/**
	 * @Title: dfs
	 * @Description: TODO
	 * @param board
	 * @param pos
	 * @return void
	 * @throws 
	 */
	private void dfs(char[][] board, int pos) {
		if (pos == spaces.size()) {
			valid = true;
			return;
		}

		int[] space = spaces.get(pos);
		int i = space[0];
		int j = space[1];
		for (int k = 0; k < 9 && !valid; ++k) {
			if (!line[i][k] && !column[j][k] && !block[i / 3][j / 3][k]) {
				line[i][k] = true;
				column[j][k] = true;
				block[i / 3][j / 3][k] = true;
				board[i][j] = (char) (k + '0' + 1);
				dfs(board, k + 1);
				line[i][k] = false;
				column[j][k] = false;
				block[i / 3][j / 3][k] = false;
			}
		}
	}
	
	
	
}
