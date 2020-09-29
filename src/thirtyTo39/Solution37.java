package thirtyTo39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：编写一个程序，通过填充空格来解决数独问题
 * 		输入： 
 * 		输出：
 * 		注意：一个数独的解法需遵循如下规则：
 * 			数字 1-9 在每一行只能出现一次。
 * 			数字 1-9 在每一列只能出现一次。
 * 			数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 			空白格用 '.' 表示。
 * 			可以假设给定的数独只有唯一解。
 * 			给定数独永远是 9x9 形式的。
 * 
 * @author yjx
 * @date 2020-9-22	
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
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

	// 存储行
	private boolean[][] line = new boolean[9][9];
	// 存储列
	private boolean[][] column = new boolean[9][9];
	// 存储一个3*3区块
	private boolean[][][] block = new boolean[3][3][9];
	// 表示是否完成九宫格
	private boolean valid = false;
	// 存储整个九宫格
	private List<int[]> spaces = new ArrayList<int[]>();

	/**
	 * @Title: solution1
	 * @Description: 递归+回溯
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
