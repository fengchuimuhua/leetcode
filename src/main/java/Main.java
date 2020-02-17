import java.util.Scanner;

public class Main {
    private final int MAX_N = 100;

    private int N;
    private int[] array = new int[MAX_N];

    public Main(Scanner sc) {
        N = sc.nextInt();
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
    }

    private void printArray() {
        System.out.print(array[0]);
        for (int i = 1; i < N; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    public void insertSort() {
        printArray();
        for (int currIx = 1; currIx < N; currIx++) {
            int value = array[currIx];
            int tmpIx = currIx-1;
            while (tmpIx >= 0 && array[tmpIx] > value) {
                array[tmpIx+1] = array[tmpIx];
                tmpIx--;
            }
            array[tmpIx+1] = value;
            printArray();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main sorter = new Main(sc);
        sorter.insertSort();
    }
}
