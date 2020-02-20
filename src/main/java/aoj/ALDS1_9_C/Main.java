package aoj.ALDS1_9_C;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/19/20
 */
public class Main {
    class PriorityQueue {
        private int len;
        private List<Long> queArr;

        public PriorityQueue() {
            len = 0;
            queArr = new ArrayList<>();
        }

        public void insert(long val) {
            len++;
            queArr.add(val);

            int currIx = len - 1;
            while (currIx > 0) {
                int parIx = (currIx - 1) / 2;
                if (queArr.get(parIx) < val) {
                    queArr.set(currIx, queArr.get(parIx));
                    currIx = parIx;
                } else {
                    break;
                }
            }
            queArr.set(currIx, val);
        }

        public long extract() {
            long ans = queArr.get(0);
            queArr.set(0, queArr.get(len - 1));
            queArr.remove(len - 1);
            len--;

            if (len == 0) return ans;

            int currIx = 0;
            long desVal = queArr.get(0);
            while (currIx * 2 + 1 < len) {
                int leftChild = currIx * 2 + 1, rightChild = currIx * 2 + 2;
                if (rightChild < len && queArr.get(rightChild) > queArr.get(leftChild)) {
                    leftChild = rightChild;
                }

                if (desVal >= queArr.get(leftChild)) break;

                queArr.set(currIx, queArr.get(leftChild));
                currIx = leftChild;
            }
            queArr.set(currIx, desVal);
            return ans;
        }
    }

    public Main(Scanner sc) {
        PriorityQueue que = new PriorityQueue();
        while (true) {
            String str = sc.next();
            if (str.equals("insert")) {
                long val = sc.nextLong();
                que.insert(val);
            } else if (str.equals("extract")) {
                long val = que.extract();
                System.out.println(val);
            } else if (str.equals("end")) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
    }
}
