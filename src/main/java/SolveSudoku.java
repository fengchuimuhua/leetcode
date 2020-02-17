/**
 * Created by zhangrunfeng on 1/19/20
 */
public class SolveSudoku {
    private boolean solveSudoku(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] grids, int currIx, int currIy) {
        if (currIx >= 9 || currIy >= 9) return true;

        int gridIx = currIx / 3 * 3 + currIy / 3;
        for (int val = 0; val < 9; val++) {
            if (rows[currIx][val] || cols[currIy][val] || grids[gridIx][val]) {
                continue;
            }

            rows[currIx][val] = true;
            cols[currIy][val] = true;
            grids[gridIx][val] = true;
            board[currIx][currIy] = (char)('1' + val);

            int nextIx = currIx, nextIy = 0;
            label:
            for (; nextIx < 9; nextIx++) {
                for (; nextIy < 9; nextIy++) {
                    if (board[nextIx][nextIy] == '.') {
                        break label;
                    }
                }
            }

            boolean flag = solveSudoku(board, rows, cols, grids, nextIx, nextIy);
            if (flag) return true;

            board[currIx][currIy] = '.';
            grids[gridIx][val] = false;
            cols[currIy][val] = false;
            rows[currIx][val] = false;
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grids = new boolean[9][9];

        // Init
        for (int ix = 0; ix < 9; ix++) {
            for (int iy = 0; iy < 9; iy++) {
                if (board[ix][iy] == '.') continue;

                int val = board[ix][iy] - '1';
                rows[ix][val] = true;
                cols[iy][val] = true;

                int gridIx = ix / 3 * 3 + iy / 3;
                grids[gridIx][val] = true;
            }
        }

        for (int ix = 0; ix < 9; ix++) {
            for (int iy = 0; iy < 9; iy++) {
                if (board[ix][iy] == '.') {
                    solveSudoku(board, rows, cols, grids, ix, iy);
                    return;
                }
            }
        }
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
        SolveSudoku s = new SolveSudoku();
        s.solveSudoku(board);
        System.out.println("res");
    }
}