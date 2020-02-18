package aoj.ALDS1_5_D;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/18/20
 */
public class Main {
    private int N;
    private int[] arr;

    public Main(Scanner sc) {
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // [startIx, endIx)
    public long mergeSort(int[] arr, int startIx, int endIx) {
        if (endIx - startIx <= 1) return 0;

        int midIx = startIx + (endIx - startIx) / 2;
        long leftSum = mergeSort(arr, startIx, midIx);
        long rightSum = mergeSort(arr, midIx, endIx);

        // merge section
        long currSum = 0;
        int[] leftArr = Arrays.copyOfRange(arr, startIx, midIx);
        int[] rightArr = Arrays.copyOfRange(arr, midIx, endIx);

        int leftIx = 0, rightIx = 0, ix = startIx;
        while (leftIx < leftArr.length && rightIx < rightArr.length) {
            if (leftArr[leftIx] <= rightArr[rightIx]) {
                arr[ix] = leftArr[leftIx];
                leftIx++;
            } else {
                arr[ix] = rightArr[rightIx];
                rightIx++;
                currSum += (leftArr.length - leftIx);
            }
            ix++;
        }
        while (leftIx < leftArr.length) {
            arr[ix] = leftArr[leftIx];
            ix++;
            leftIx++;
        }
        while (rightIx < rightArr.length) {
            arr[ix] = rightArr[rightIx];
            ix++;
            rightIx++;
        }

        return leftSum + rightSum + currSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        long res = m.mergeSort(m.arr, 0, m.N);
        System.out.println(res);
    }
}
