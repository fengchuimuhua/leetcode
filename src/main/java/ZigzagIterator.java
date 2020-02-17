import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangrunfeng on 1/17/20
 */
public class ZigzagIterator {

    private List<List<Integer>> v;

    private int vSize;

    private int rowIx;

    private int colIx;

    public ZigzagIterator(List<List<Integer>> v) {
        this.v = v;
        rowIx = 0;
        colIx = 0;

        vSize = v.size();
        int count = 1;
        while (count < vSize) {
            if (v.get(rowIx) == null || colIx >= v.get(rowIx).size()) {
                rowIx++;
            } else {
                break;
            }
            count += 1;
        }
    }

    public int next() {
        int res = v.get(rowIx).get(colIx);

        rowIx += 1;
        if (rowIx >= vSize) {
            rowIx = 0;
            colIx += 1;
        }

        int count = 1;
        while (count < vSize) {
            if (v.get(rowIx) == null || colIx >= v.get(rowIx).size()) {
                rowIx += 1;
                if (rowIx >= vSize) {
                    rowIx = 0;
                    colIx += 1;
                }
            } else {
                break;
            }

            count += 1;
        }

        return res;
    }

    public boolean hasNext() {
        if (v != null && v.get(rowIx) != null && colIx < v.get(rowIx).size()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 4, 6, 8, 9);
        List<Integer> v2 = Collections.singletonList(2);
        List<Integer> v3 = null;
        List<Integer> v4 = Arrays.asList(3, 5, 7);

        List<List<Integer>> v = Arrays.asList(v1, v2, v3, v4);


        ZigzagIterator iterator = new ZigzagIterator(v);
        while (iterator.hasNext()) {
            int next = iterator.next();
            System.out.print(next + " ");
        }

        System.out.println(Math.log(64) / Math.log(2));


    }
}

// 1 4 6 8 9
// 2
// #
// 3 5 7