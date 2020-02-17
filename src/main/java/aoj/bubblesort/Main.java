package aoj.bubblesort;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/16/20
 */
public class Main {
    private int N;
    private int[] arr;

    public Main(Scanner sc){
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    private void printArr() {
        for (int i = 0; i < N-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[N-1]);
    }

    public void bubbleSort() {
        int count = 0;
        for (int endIx = 0; endIx < N; endIx++) {
            boolean flag = true;
            for (int i = N-1; i > endIx; i--) {
                if (arr[i-1] > arr[i]) {
                    flag = false;
                    count++;
                    int tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                }
            }
            if (flag) {
                break;
            }
        }
        printArr();
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.bubbleSort();
    }
}
