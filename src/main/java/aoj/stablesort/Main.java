package aoj.stablesort;

import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2/16/20
 */
public class Main {

    class Card{
        public char suit;
        public int value;

        public Card(char suit, int value) {
            this.suit = suit;
            this.value = value;
        }

        @Override
        public String toString() {
            return Character.toString(suit) + Integer.toString(value);
        }
    }

    private int N;
    private Card[] arr1;
    private Card[] arr2;

    public Main(Scanner sc) {
        N = sc.nextInt();
        arr1 = new Card[N];
        arr2 = new Card[N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            arr1[i] = new Card(str.charAt(0), Integer.parseInt(str.substring(1)));
            arr2[i] = arr1[i];
        }
    }

    public void printArray(Card arr[], int N) {
        for (int i = 0; i < N-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[N-1]);
    }

    public void bubbleSort(Card[] arr, int N) {
        for (int endIx = 0; endIx < N; endIx++) {
            boolean flag = true;
            for (int i = N-1; i > endIx; i--) {
                if (arr[i-1].value > arr[i].value) {
                    flag = false;
                    Card tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public void selectionSort(Card[] arr, int N) {
        for (int i = 0; i < N-1; i++) {
            int minIx = i;
            for (int j = minIx+1; j < N; j++) {
                if (arr[j].value < arr[minIx].value) {
                    minIx = j;
                }
            }
            if (minIx != i) {
                // swap arr[i] & arr[minIx]
                Card tmp = arr[i]; arr[i] = arr[minIx]; arr[minIx] = tmp;
            }
        }
    }

    private boolean isStable(Card[] arr1, Card[] arr2, int N) {
        boolean res = true;
        for (int i = 0; i < N; i++) {
            if (arr1[i].suit != arr2[i].suit || arr1[i].value != arr2[i].value) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.bubbleSort(m.arr1, m.N);
        m.printArray(m.arr1, m.N);
        System.out.println("Stable");
        m.selectionSort(m.arr2, m.N);
        m.printArray(m.arr2, m.N);

        boolean isStable = m.isStable(m.arr1, m.arr2, m.N);
        if (isStable) {
            System.out.println("Stable");
        } else {
            System.out.println("Not stable");
        }
    }
}
