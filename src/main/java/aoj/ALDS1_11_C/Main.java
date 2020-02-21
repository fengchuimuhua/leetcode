package aoj.ALDS1_11_C;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/21/20
 */
public class Main {
    private int N;
    private int[][] G;

    private int[] distance;

    public Main(Scanner sc) {
        N = sc.nextInt();
        G = new int[N][];
        for (int i = 0; i < N; i++) {
            G[i] = new int[N];
        }
        for (int i = 0; i < N; i++) {
            int u = sc.nextInt() - 1;
            int adjNum = sc.nextInt();
            for (int j = 0; j < adjNum; j++) {
                int v = sc.nextInt() - 1;
                G[u][v] = 1;
            }
        }

        distance = new int[N];
        Arrays.fill(distance, -1);
    }

    public void bfs(int node) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(node);
        distance[node] = 0;

        while (!que.isEmpty()) {
            int currNode = que.poll();
            for (int i = 0; i < N; i++) {
                if (distance[i] < 0 && G[currNode][i] == 1) {
                    que.offer(i);
                    distance[i] = distance[currNode] + 1;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(i+1 + " " + distance[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.bfs(0);
        m.print();
    }
}
