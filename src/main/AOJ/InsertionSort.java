import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2019-04-30
 */
public class InsertionSort {

    private int N;
    private int[] array;

    public void init(Scanner sc) {
        N = sc.nextInt();
        array = new int[N];
        for (int idx = 0; idx < N; idx++) {
            array[idx] = sc.nextInt();
        }
    }

    private void printArray() {
        for (int idx = 0; idx < N-1; idx++) {
            System.out.print(array[idx] + " ");
        }
        System.out.println(array[N-1]);
    }

    public void insertionSort() {
        printArray();
        for (int idx = 1; idx < N; idx++) {
            int currEle = array[idx];
            int preIdx = idx-1;
            while ((preIdx >= 0)
                    && (array[preIdx] > currEle)) {
                array[preIdx+1] = array[preIdx];
                preIdx -= 1;
            }
            array[preIdx+1] = currEle;
            printArray();
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        Scanner sc = new Scanner(System.in);
        insertionSort.init(sc);
        insertionSort.insertionSort();
    }
}
