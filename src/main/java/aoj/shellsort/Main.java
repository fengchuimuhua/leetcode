package aoj.shellsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private int N;
    private int[] arr;
    private int cnt;
    private List<Integer> G;

    public Main(Scanner sc) {
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        cnt = 0;
    }

    private void insertionSort(int g) {
        for (int i = g; i < N; i++) {
            int j = i - g;
            int val = arr[i];
            while (j >= 0 && arr[j] > val) {
                arr[j+g] = arr[j];
                cnt++;
                j = j-g;
            }
            arr[j+g] = val;
        }
    }

    private void shellSort() {
        G = new ArrayList<>();
        for (int i = 1; ; i = i*3+1) {
            if (i <= N) {
                G.add(i);
            } else {
                break;
            }
        }

        for (int ix = G.size()-1; ix >= 0; ix--) {
            insertionSort(G.get(ix));
        }
    }

    private void printArray() {
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.shellSort();

        System.out.println(m.G.size());
        for (int ix = m.G.size()-1; ix > 0; ix--) {
            System.out.print(m.G.get(ix) + " ");
        }
        System.out.println(m.G.get(0));
        System.out.println(m.cnt);
        m.printArray();
    }
}