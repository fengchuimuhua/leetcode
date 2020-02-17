import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangrunfeng on 1/20/20
 */
public class ChangeGrids {

    static class Pair {
        int x;
        int y;

        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};

    // return whether the grid(ix x iy) is necessary to be changed into 'X'
    private boolean bfs(char[][] board, boolean[][] flag, int ix, int iy) {
        if (board[ix][iy] == 'X' || flag[ix][iy]) {
            return false;
        }

        int height = board.length;
        int width = board[0].length;

        boolean res = true;

        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(ix, iy));
        flag[ix][iy] = true;
        while (!que.isEmpty()) {
            Pair p = que.poll();

            if (p.x == 0 || p.x == height-1 || p.y == 0 || p.y == width-1) {
                res = false;
            }

            for (int k = 0; k < 4; k++) {
                int nextIx = p.x + dx[k], nextIy = p.y + dy[k];
                if (nextIx < 0 || nextIx >= height || nextIy < 0 || nextIy >= width
                        || board[nextIx][nextIy] == 'X'
                        || flag[nextIx][nextIy]) {
                    continue;
                }

                que.offer(new Pair(nextIx, nextIy));
                flag[nextIx][nextIy] = true;
            }
        }

        return res;
    }

    // change grids
    private void bfsChangeGrids (char[][] board, int ix, int iy) {
        if (board[ix][iy] == 'X') {
            return;
        }

        int height = board.length;
        int width = board[0].length;

        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(ix, iy));
        board[ix][iy] = 'X';
        while (!que.isEmpty()) {
            Pair p = que.poll();

            for (int k = 0; k < 4; k++) {
                int nextIx = p.x + dx[k], nextIy = p.y + dy[k];
                if (nextIx < 0 || nextIx >= height || nextIy < 0 || nextIy >= width
                        || board[nextIx][nextIy] == 'X') {
                    continue;
                }

                que.offer(new Pair(nextIx, nextIy));
                board[nextIx][nextIy] = 'X';
            }
        }
    }

    public void solve(char[][] board) {
        int height = board.length;
        if (height == 0) {
            return;
        }
        int width = board[0].length;
        if (width == 0) {
            return;
        }

        boolean[][] flag = new boolean[height][width];
        for (int ix = 0; ix < height; ix++) {
            for (int iy = 0; iy < width; iy++) {
                boolean ifChange = bfs(board, flag, ix, iy);
                if (ifChange) {
                    bfsChangeGrids(board, ix, iy);
                }
            }
        }
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},{'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},{'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},{'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},{'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},{'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},{'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}};
//        ChangeGrids cg = new ChangeGrids();
//        cg.solve(board);

        System.out.println("Hello");
    }
}
