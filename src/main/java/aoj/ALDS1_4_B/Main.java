package aoj.ALDS1_4_B;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/17/20
 */

public class Main {
    private int N;
    private int[] increArr;

    private int Q;
    private int[] arrQ;

    public Main (Scanner sc) {
        N = sc.nextInt();
        increArr = new int[N];
        for (int i = 0; i < N; i++) {
            increArr[i] = sc.nextInt();
        }

        Q = sc.nextInt();
        arrQ = new int[Q];
        for (int i = 0; i < Q; i++) {
            arrQ[i] = sc.nextInt();
        }
    }

    private boolean binarySearch(int targetVal) {
        int leftIx = 0, rightIdx = N-1;
        while (leftIx <= rightIdx) {
            int midIx = leftIx + (rightIdx - leftIx) / 2;
            if (increArr[midIx] == targetVal) {
                return true;
            } else if (increArr[midIx] > targetVal) {
                rightIdx = midIx - 1;
            } else {
                leftIx = midIx + 1;
            }
        }
        return false;
    }

    public int countQinN() {
        int count = 0;
        for (int targetVal : arrQ) {
            if (binarySearch(targetVal)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        int res = m.countQinN();
        System.out.println(res);
    }
}
