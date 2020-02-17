/**
 * Created by zhangrunfeng on 1/19/20
 */
public class Soduku {
    public boolean isValidSudoku(char[][] board) {
        // 检查横向是否有效
        boolean[][] rows = new boolean[9][9];

        // 检查纵向是否有效
        boolean[][] cols = new boolean[9][9];

        // 检查9宫格是否有效
        boolean[][] grids = new boolean[9][9];

        for (int ix = 0; ix < 9; ix++) {
            for (int iy = 0; iy < 9; iy++) {
                if (board[ix][iy] == '.') continue;

                int val = board[ix][iy] - '1';
                if (rows[ix][val]){
                    return false;
                } else {
                    rows[ix][val] = true;
                }
                if (cols[iy][val]){
                    return false;
                } else {
                    cols[iy][val] = true;
                }

                int gridIx = ix / 3, gridIy = iy / 3;
                if (grids[gridIx * 3 + gridIy][val]) {
                    return false;
                } else {
                    grids[gridIx * 3 + gridIy][val] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};
        Soduku s = new Soduku();
        boolean res = s.isValidSudoku(board);
        System.out.println(res);
    }
}
