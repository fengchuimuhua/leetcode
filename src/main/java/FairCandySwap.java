/**
 * Created by zhangrunfeng on 2019-04-17
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        long sumA = 0;
        for (int idx = 0; idx < A.length; idx++) {
            sumA += A[idx];
        }
        long sumB = 0;
        for (int idx = 0; idx < B.length; idx++) {
            sumB += B[idx];
        }

        int[] res = new int[2];
        for (int idxA = 0; idxA < A.length; idxA++) {
            for (int idxB = 0; idxB < B.length; idxB++) {
                if ((sumA - A[idxA] + B[idxB]) == (sumB - B[idxB] + A[idxA])) {
                    res[0] = A[idxA];
                    res[1] = B[idxB];
                    return res;
                }
            }
        }
        return res;
    }
}
