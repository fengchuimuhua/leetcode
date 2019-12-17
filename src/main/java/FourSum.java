import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhangrunfeng on 12/17/19
 */

class Element {
    public int sum;
    public int firstIdx;
    public int secondIdx;

    public Element (int sum, int firstIdx, int secondIdx) {
        this.sum = sum;
        this.firstIdx = firstIdx;
        this.secondIdx = secondIdx;
    }
}

public class FourSum {

    private int findStartPos(List<Element> eleList, int target, int lastIdx) {
        if (eleList.isEmpty()) {
            return -1;
        }

        int leftIdx = 0, rightIdx = eleList.size()-1;
        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (eleList.get(midIdx).sum < target) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }
        }
        int firstRes = leftIdx; // first element larger OR equal to target

        leftIdx = 0;
        rightIdx = eleList.size()-1;
        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (eleList.get(midIdx).sum <= target) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }
        }
        int secondRes = rightIdx;	// last element equal to OR smaller than target

        if (firstRes > secondRes) {
            return -1;
        }

        leftIdx = firstRes;
        rightIdx = secondRes;
        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            if (eleList.get(midIdx).firstIdx <= lastIdx) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }
        }

        if (rightIdx > secondRes) {
            return -1;
        }
        return leftIdx;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        List<Element> eleList = new ArrayList<Element>();
        for (int idx = nums.length-1; idx > 2; idx--) {
            if ((idx < nums.length-1) && (nums[idx] == nums[idx+1])) continue;

            for (int idx2 = idx-1; idx2 >= 2; idx2--) {
                if ((idx2 < idx-1) && (nums[idx2] == nums[idx2+1])) continue;

                Element ele = new Element(nums[idx] + nums[idx2], idx2, idx);
                eleList.add(ele);
            }
        }

        eleList.sort(new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2) {
                if (e1.sum > e2.sum) {
                    return 1;
                } else if (e1.sum < e2.sum) {
                    return -1;
                } else {
                    if (e1.firstIdx > e2.firstIdx) {
                        return 1;
                    } else return -1;
                }
            }
        });

        for (int idx = 0; idx < nums.length-3; idx++) {
            if ((idx > 0) && (nums[idx] == nums[idx-1])) continue;

            for (int idx2 = idx+1; idx2 < nums.length-2; idx2++) {
                if ((idx2 > idx+1) && (nums[idx2] == nums[idx2-1])) continue;

                int residual = target-nums[idx]-nums[idx2];
                int pos = findStartPos(eleList, residual, idx2);

                if (pos == -1) continue;

                while ((pos < eleList.size()) && (residual == eleList.get(pos).sum)) {
                    List<Integer> currList = Arrays.asList(nums[idx], nums[idx2], nums[eleList.get(pos).firstIdx], nums[eleList.get(pos).secondIdx]);
                    res.add(currList);
                    pos++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();

        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;

        List<List<Integer>> res = fs.fourSum(nums, target);

        System.out.println("res");
    }
}