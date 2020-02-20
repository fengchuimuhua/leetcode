package aoj.ALDS1_11_A;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/20/20
 */
public class Main {
    public int N;
    public int[][] G;

    public Main(Scanner sc) {
        N = sc.nextInt();
        G = new int[N][];
        for (int i = 0; i < N; i++) {
            G[i] = new int[N];
        }

        for (int i = 0; i < N; i++) {
            int u = sc.nextInt()-1;
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int v = sc.nextInt()-1;
                G[u][v] = 1;
            }
        }
    }

    public void printAdjMat() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                System.out.print(G[i][j] + " ");
            }
            System.out.println(G[i][N-1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.printAdjMat();
    }
}
