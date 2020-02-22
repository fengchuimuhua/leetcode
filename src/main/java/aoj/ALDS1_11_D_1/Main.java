package aoj.ALDS1_11_D_1;

import java.util.*;

/**
 * Created by zhangrunfeng on 2/21/20
 */
public class Main {

    class Node {
        List<Integer> adjNodeList;

        public Node() {
            this.adjNodeList = new ArrayList<>();
        }
    }

    private int N;
    private Node[] nodes;
    private int[] colors;
    private int[] next;

    public Main(Scanner sc) {
        N = sc.nextInt();
        nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node();
        }

        colors = new int[N];
        next = new int[N];

        int edgeNum = sc.nextInt();
        for (int i = 0; i < edgeNum; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            nodes[u].adjNodeList.add(v);
            nodes[v].adjNodeList.add(u);
        }

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
        int color = 1;
        for (int i = 0; i < N; i++) {
            if (colors[i] == 0) {
                dfs(i, color);
                color++;
            }
        }
    }

    private int getNext(int node) {
        for (int i = next[node]; i < nodes[node].adjNodeList.size(); i++) {
            int nextNode = nodes[node].adjNodeList.get(i);
            if (colors[nextNode] == 0) {
                next[node] = i+1;
                return nextNode;
            }
        }
        return -1;
    }

    public void dfs(int node, int color) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(node);
        colors[node] = color;

        while (!st.isEmpty()) {
            int currNode = st.peek();
            int nextNode = getNext(currNode);
            if (nextNode > 0) {
                st.push(nextNode);
                colors[nextNode] = color;
            } else {
                st.pop();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
    }
}
