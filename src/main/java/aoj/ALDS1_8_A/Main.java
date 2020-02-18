package aoj.ALDS1_8_A;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/18/20
 */
public class Main {

    private int N;
    private Node root;

    class Node {
        long val;
        Node left;
        Node right;

        public Node (long val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private void inOrder(Node root, StringBuilder sb) {
        if (root == null) return;

        if (root.left != null) {
            inOrder(root.left, sb);
            sb.append(" ");
        }

        sb.append(root.val);

        if (root.right != null) {
            sb.append(" ");
            inOrder(root.right, sb);
        }
    }

    private void preOrder(Node root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val);
        if (root.left != null) {
            sb.append(" ");
            preOrder(root.left, sb);
        }
        if (root.right != null) {
            sb.append(" ");
            preOrder(root.right, sb);
        }
    }

    public Main(Scanner sc) {
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            if (str.equals("insert")) {
                long val = sc.nextLong();
                Node currNode = new Node(val);
                if (root == null) {
                    root = currNode;
                } else {
                    Node tmp = root;
                    while (true) {
                        if (currNode.val < tmp.val) {
                            if (tmp.left != null) {
                                tmp = tmp.left;
                            } else {
                                tmp.left = currNode;
                                break;
                            }
                        } else {
                            if (tmp.right != null) {
                                tmp = tmp.right;
                            } else {
                                tmp.right = currNode;
                                break;
                            }
                        }
                    }
                }
            } else if (str.equals("print")) {
                StringBuilder sb = new StringBuilder();
                inOrder(root, sb);
                System.out.println(" " + sb.toString());
                sb.setLength(0);
                preOrder(root, sb);
                System.out.println(" " + sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
    }
}
