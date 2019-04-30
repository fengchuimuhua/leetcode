import java.util.Scanner;

/**
 * Created by zhangrunfeng on 2019-04-30
 */
public class BubbleSort {

    private int arrayLen;
    private int arr[];

    private void init(Scanner sc) {
        arrayLen = sc.nextInt();
        arr = new int[arrayLen];
        for (int idx = 0; idx < arrayLen; idx++) {
            arr[idx] = sc.nextInt();
        }
    }

    private void printArray() {
        for (int idx = 0; idx < arrayLen-1; idx++) {
            System.out.print(arr[idx] + " ");
        }
        System.out.println(arr[arrayLen-1]);
    }

    private int bubbleSort() {
        int count = 0;

        boolean flag = true;
        for (int iter = 0; iter < arrayLen-1; iter+=1) {
            if (!flag) break;
            flag = false;

            for (int idx = 0; idx < arrayLen-1-iter; idx+=1) {
                if (arr[idx] > arr[idx+1]) {
                    count += 1;

                    // swap arr[idx] and arr[idx+1]
                    int tmp = arr[idx];
                    arr[idx] = arr[idx+1];
                    arr[idx+1] = tmp;
                    flag = true;
                }
            }

        }

        printArray();

        return count;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Scanner sc = new Scanner(System.in);
        bubbleSort.init(sc);
        int res = bubbleSort.bubbleSort();
        System.out.println(res);
    }
}
