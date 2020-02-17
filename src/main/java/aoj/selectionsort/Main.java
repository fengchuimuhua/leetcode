package aoj.selectionsort;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/16/20
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

    public void printArray() {
        for (int i = 0; i < N-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[N-1]);
    }

    public void selectionSort() {
        int count = 0;
        for (int i = 0; i < N-1; i++) {
            int minIx = i;
            for (int j = minIx+1; j < N; j++) {
                if (arr[j] < arr[minIx]) {
                    minIx = j;
                }
            }
            if (minIx != i) {
                count++;
                // swap arr[i] & arr[minIx]
                int tmp = arr[i]; arr[i] = arr[minIx]; arr[minIx] = tmp;
            }
        }
        printArray();
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.selectionSort();
    }
}
