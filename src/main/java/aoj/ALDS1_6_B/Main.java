package aoj.ALDS1_6_B;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/17/20
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

    public int partition(int p, int r) {
        int pivot = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[r] = arr[i + 1];
        arr[i + 1] = pivot;
        return i + 1;
    }

    public void printResult(int startIx, int endIx, int partitionIx) {
        for (int ix = startIx; ix < endIx-1; ix++) {
            if (ix == partitionIx) {
                System.out.print("[");
            }
            System.out.print(arr[ix]);
            if (ix == partitionIx) {
                System.out.print("]");
            }
            System.out.print(" ");
        }
        if (endIx-1 == partitionIx) {
            System.out.print("[");
        }
        System.out.println(arr[endIx-1]);
        if (endIx-1 == partitionIx) {
            System.out.print("]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        int partitionIx = m.partition(0, m.N - 1);
        m.printResult(0, m.N, partitionIx);
    }
}
