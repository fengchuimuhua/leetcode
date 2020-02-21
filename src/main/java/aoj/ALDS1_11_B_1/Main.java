package aoj.ALDS1_11_B_1;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/21/20
 */
public class Main {

    private int N;
    private int[][] G;

    public int[] start;
    public int[] end;

    private int[] next;
    private int time;

    private boolean[] visit;

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

        start = new int[N];
        end = new int[N];
        next = new int[N];
        visit = new boolean[N];

        time = 1;
    }

//    private int getNext(int currNode) {
//        for(int i = 0; i < N; i++) {
//            if (!visit[i] && G[currNode][i] == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public void dfsVisit(int node) {
        start[node] = time;
        time++;
        visit[node] = true;

//        int nextNode = getNext(node);
//        while (nextNode != -1) {
//            dfsVisit(nextNode);
//            nextNode = getNext(node);
//        }
        for (int i = 0; i < N; i++) {
            if (!visit[i] && G[node][i] == 1) {
                dfsVisit(i);
            }
        }

        end[node] = time;
        time++;
    }

    public void dfs() {
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                dfsVisit(i);
            }
        }
    }

    public void printResult() {
        for (int i = 0; i < N; i++) {
            System.out.println(i+1 + " " + start[i] + " " + end[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.dfs();
        m.printResult();
    }
}
