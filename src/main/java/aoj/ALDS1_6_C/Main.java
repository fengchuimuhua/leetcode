package aoj.ALDS1_6_C;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/17/20
 */
public class Main {

    public int N;
    public Card[] mergeSortArr;
    public Card[] quickSortArr;

    private Card[] tmpArr;

    static class Card {
        public char suit;
        public int value;

        public Card(char suit, int value) {
            this.suit = suit;
            this.value = value;
        }
    }

    public Main(Scanner sc) {
        N = sc.nextInt();
        mergeSortArr = new Card[N];
        quickSortArr = new Card[N];
        for (int i = 0; i < N; i++) {
            char suit = sc.next().charAt(0);
            int value = sc.nextInt();
            mergeSortArr[i] = new Card(suit, value);
            quickSortArr[i] = mergeSortArr[i];
        }
        tmpArr = new Card[N];
    }

    public void mergeSort(Card[] arr, int startIx, int endIx) {
        if (endIx - startIx <= 1) return;

        int midIx = startIx + (endIx - startIx) / 2;
        mergeSort(arr, startIx, midIx);
        mergeSort(arr, midIx, endIx);

        // merge section
        for (int i = startIx; i < endIx; i++) {
            tmpArr[i] = arr[i];
        }

        int ix1 = startIx, ix2 = midIx, ix = startIx;
        while (ix1 < midIx && ix2 < endIx) {
            if (tmpArr[ix1].value <= tmpArr[ix2].value) {
                arr[ix] = tmpArr[ix1];
                ix1++;
            } else {
                arr[ix] = tmpArr[ix2];
                ix2++;
            }
            ix++;
        }
        while (ix1 < midIx) {
            arr[ix] = tmpArr[ix1];
            ix++;
            ix1++;
        }
        while (ix2 < endIx) {
            arr[ix] = tmpArr[ix2];
            ix++;
            ix2++;
        }
    }

    // [startIx, endIx)
    public int partition(Card[] arr, int startIx, int endIx) {
        int parIx = startIx - 1;
        int pivotVal = arr[endIx - 1].value;
        for (int ix = startIx; ix < endIx; ix++) {
            if (arr[ix].value <= pivotVal) {
                parIx++;
                Card tmp = arr[ix];
                arr[ix] = arr[parIx];
                arr[parIx] = tmp;
            }
        }
        return parIx;
    }

    public void quickSort(Card[] arr, int startIx, int endIx) {
        if (endIx - startIx <= 1) return;
        int parIx = partition(arr, startIx, endIx);
        quickSort(arr, startIx, parIx);
        quickSort(arr, parIx+1, endIx);
    }

    public void printArr(Card[] arr) {
        for (Card card : arr) {
            System.out.println(card.suit + " " + String.valueOf(card.value));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.mergeSort(m.mergeSortArr, 0, m.N);
        m.quickSort(m.quickSortArr, 0, m.N);

        boolean flag = true;
        for (int i = 0; i < m.N; i++) {
            if (m.quickSortArr[i] != m.mergeSortArr[i]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("Stable");
        } else {
            System.out.println("Not stable");
        }
        m.printArr(m.quickSortArr);
    }
}
