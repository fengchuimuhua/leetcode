package aoj.ALDS1_11_B;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/20/20
 */
public class Main {

    public enum State {
        WHITE(0), GRAY(1), BLACK(2),
        ;

        int type;

        State(int type) {
            this.type = type;
        }

        State() {
            this.type = 0;
        }
    }

    private int N;
    private int[][] G;

    private int[] start;
    private int[] end;

    private State[] states;
    private int[] nt;

    private int time;

    public Main(Scanner sc) {
        N = sc.nextInt();
        G = new int[N][];
        for (int i = 0; i < N; i++) {
            G[i] = new int[N];
        }

        // G initialization
        for (int i = 0; i < N; i++) {
            int u = sc.nextInt() - 1;
            int adjNum = sc.nextInt();
            for (int j = 0; j < adjNum; j++) {
                int v = sc.nextInt() - 1;
                G[u][v] = 1;
            }
        }

        // Other initialization
        start = new int[N];
        end = new int[N];

        states = new State[N];
        for (int i = 0; i < N; i++) {
            states[i] = State.WHITE;
        }

        nt = new int[N];

        time = 1;
    }

    private int getNext(int node) {
        for (int i = nt[node]; i < N; i++) {
            if (states[i] == State.WHITE && G[node][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    private void dfsVisit(int node) {
        Deque<Integer> st = new LinkedList<>();

        st.push(node);
        states[node] = State.GRAY;
        start[node] = time;
        time++;

        while (!st.isEmpty()) {
            Integer topNode = st.peek();
            int nextNode = getNext(topNode);

            if (nextNode >= 0) {
                st.push(nextNode);
                states[nextNode] = State.GRAY;
                start[nextNode] = time;
                time++;
            } else {
                st.pop();
                states[topNode] = State.BLACK;
                end[topNode] = time;
                time++;
            }
        }
    }

    public void dfs() {
        for (int i = 0; i < N; i++) {
            if (states[i] == State.WHITE) {
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
