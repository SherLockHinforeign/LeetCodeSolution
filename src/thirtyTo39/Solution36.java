package thirtyTo39;

import java.util.HashMap;

/**
 * @ClassName: Solution
 * @Description: 
 * 		题目：判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 				数字 1-9 在每一行只能出现一次。
 * 				数字 1-9 在每一列只能出现一次。
 * 				数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 		输入：
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
 * 		输出： true
 * 		注意：	一个有效的数独（部分已被填充）不一定是可解的。
 * 				只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 				给定数独序列只包含数字 1-9 和字符 '.' 。
 * 				给定数独永远是 9x9 形式的。
 * 
 * @author yjx
 * @date 2020-9-22
 * @Note Commit Message ： 12位时间加一个 . 加项目名LeetCode（例：202009111720.LeetCode）
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
	 * @Description: 一次扫描
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
