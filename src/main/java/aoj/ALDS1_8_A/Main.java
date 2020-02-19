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

        public Node(long val) {
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

    private boolean find(long targetVal) {
        Node tmp = root;
        while (tmp != null) {
            if (tmp.val == targetVal) {
                return true;
            } else if (tmp.val < targetVal) {
                tmp = tmp.right;
            } else {
                tmp = tmp.left;
            }
        }
        return false;
    }

    private boolean delete(long targetVal) {
        Node pre = null, cur = root;
        while (cur != null && cur.val != targetVal) {
            pre = cur;
            if (targetVal < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (cur == null) {
            return false;
        }

        if (!(cur.left != null && cur.right != null)) {
            // 待删除结点至多只有一个子结点
            Node childNode;
            if (cur.left != null) {
                childNode = cur.left;
            } else {
                childNode = cur.right;
            }
            cur.left = null;
            cur.right = null;

            if (pre == null) {
                root = childNode;
                return true;
            } else {
                if (pre.left == cur) {
                    pre.left = childNode;
                } else {
                    pre.right = childNode;
                }
                return true;
            }
        } else {
            // 待删除结点包含左右两个子结点
            Node preStar = cur, curStar = cur.right;
            while (curStar.left != null) {
                preStar = curStar;
                curStar = curStar.left;
            }
            cur.val = curStar.val;
            if (preStar.left == curStar) {
                preStar.left = curStar.right;
            } else {
                preStar.right = curStar.right;
            }
            curStar.right = null;
            return true;
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
            } else if (str.equals("find")) {
                long targetVal = sc.nextLong();
                boolean ifFind = find(targetVal);
                if (ifFind) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else if (str.equals("delete")) {
                long target = sc.nextLong();
                delete(target);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
    }
}
