/**
 * Created by zhangrunfeng on 2019-04-29
 */
import java.util.Scanner;

public class MaximumProfit {
    private static final int MAXSIZE = 200000;

    public static void main(String[] args) {
        int[] R = new int[MAXSIZE];

        Scanner sc = new Scanner(System.in);
        int rLength = sc.nextInt();

        for (int idx = 0; idx < rLength; idx++) {
            R[idx] = sc.nextInt();
        }

        int res = Integer.MIN_VALUE;
        int currMin = R[0];
        for (int idx = 1; idx < rLength; idx++) {
            res = Math.max(res, R[idx] - currMin);
            currMin = Math.min(currMin, R[idx]);
        }

        System.out.println(res);
    }
}
