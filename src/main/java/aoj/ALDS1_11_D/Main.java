package aoj.ALDS1_11_D;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/21/20
 */
public class Main {
    private int N;
    private int[][] G;
    private int[] colors;
    private int[] next;

    public Main(Scanner sc) {
        N = sc.nextInt();
        G = new int[N][];
        for (int i = 0; i < N; i++) {
            G[i] = new int[N];
        }

        int edgeNum = sc.nextInt();
        for (int i = 0; i < edgeNum; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            G[u][v] = 1;
            G[v][u] = 1;
        }

        colors = new int[N];
        next = new int[N];

        process();

        int qesNum = sc.nextInt();
        for (int i = 0; i < qesNum; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            if (colors[u] == colors[v]) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public void process() {
        int currColor = 1;
        for (int i = 0; i < N; i++) {
            if (colors[i] == 0) {
                dfs(i, currColor);
                currColor++;
            }
        }
    }

    private void dfs(int node, int currColor) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(node);
        colors[node] = currColor;

        while (!st.isEmpty()) {
            int currNode = st.peek();
            int nextNode = getNext(currNode);
            if (nextNode >= 0) {
                st.push(nextNode);
                colors[nextNode] = currColor;
            } else {
                st.pop();
            }
        }
    }

    private int getNext(int node) {
        for (int i = next[node]; i < N; i++) {
            if (colors[i] == 0 && G[node][i] == 1) {
                next[node] = i+1;
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
    }
}
