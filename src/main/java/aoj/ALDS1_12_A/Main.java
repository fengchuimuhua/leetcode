package aoj.ALDS1_12_A;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/22/20
 */
public class Main {

    private int N;
    private int[][] G;
    private final int MAX = Integer.MAX_VALUE;

    private boolean[] visit;
    public int[] d;

    public Main(Scanner sc) {
        N = sc.nextInt();
        G = new int[N][];
        for (int i = 0; i < N; i++) {
            G[i] = new int[N];
            for (int j = 0; j < N; j++) {
                int e = sc.nextInt();
                if (e == -1) {
                    e = MAX;
                }
                G[i][j] = e;
            }
        }

        visit = new boolean[N];
        d = new int[N];
        for (int i = 0; i < N; i++) {
            d[i] = MAX;
        }
    }

    public int prim() {
        for (int i = 0; i < N; i++) {
            d[i] = MAX;
        }
        d[0] = 0;

        int ans = 0;
        while(true) {
            // 找到下一个放入的结点
            int nextNode = -1;
            for (int i = 0; i < N; i++) {
                if (!visit[i] && (nextNode == -1 || d[i] < d[nextNode])) {
                    nextNode = i;
                }
            }

            if (nextNode == -1) break;

            ans += d[nextNode];
            visit[nextNode] = true;
            // 更新数组d
            for (int i = 0; i < N; i++) {
                d[i] = Math.min(d[i], G[i][nextNode]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        int res = m.prim();
        System.out.println(res);
    }
}
